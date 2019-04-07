package org.fh.shop.admin.mays.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.Transfer;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.TransferProgress;
import com.qcloud.cos.transfer.Upload;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QQCOSUtil {

    private static final String webappurl = "https://ceshi-1258861074.cos.ap-beijing.myqcloud.com/";
    private static final String appkey = "AKIDHLBl59nYte9ON6lTHpAF5yby6yayghaE";
    private static final String secretKey = "av0B6nFRKyymBOMp68yZ1IOjodCVYPIv";
    private static final String bucket = "ceshi-1258861074";
    private static final String region = "ap-beijing";

    // 从输入流进行读取并上传到COS
    public static void SimpleUploadFileFromStream(File file, String fileName) {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSClient cosclient = buildCosClient();
        int index = fileName.lastIndexOf(".");
        String key = UUID.randomUUID().toString() + fileName.substring(index);
        File localFile = file;

        InputStream input = new ByteArrayInputStream(new byte[10]);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 从输入流上传必须制定content length, 否则http客户端可能会缓存所有数据，存在内存OOM的情况
        objectMetadata.setContentLength(10);
        // 默认下载时根据cos路径key的后缀返回响应的contenttype, 上传时设置contenttype会覆盖默认值
        objectMetadata.setContentType("image/jpeg");

        PutObjectRequest putObjectRequest =
                new PutObjectRequest(bucket, key, input, objectMetadata);
        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard);
        try {
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();
            System.out.println(etag);
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 关闭客户端
        cosclient.shutdown();
    }


    public static void main(String[] args) {
        File file = new File("E:/images/5a0fe692a0d2b.jpg");
        SimpleUploadFileFromStream(file, "5a0fe692a0d2b.jpg");
        String s = uploadFile(file, "5a0fe692a0d2b.jpg");
        System.out.println(s);
    }

    private static void showTransferProgress(Transfer transfer) {
        System.out.println(transfer.getDescription());
        do {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
            TransferProgress progress = transfer.getProgress();
            long so_far = progress.getBytesTransferred();
            long total = progress.getTotalBytesToTransfer();
            double pct = progress.getPercentTransferred();
            System.out.printf("[%d / %d]\n", so_far, total);
        } while (transfer.isDone() == false);
        System.out.println(transfer.getState());
    }

    // 上传文件, 根据文件大小自动选择简单上传或者分块上传。
    //将对应的文件传输到cos存储桶内
    public static String uploadFile(File file, String fileName) {
        COSClient cosclient = buildCosClient();


        ExecutorService threadPool = Executors.newFixedThreadPool(32);
        // 传入一个threadpool, 若不传入线程池, 默认TransferManager中会生成一个单线程的线程池。
        TransferManager transferManager = new TransferManager(cosclient, threadPool);
        int index = fileName.lastIndexOf(".");
        String key = DateUtils.getDate()+"/"+UUID.randomUUID().toString() + fileName.substring(index);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, file);
        try {
            // 返回一个异步结果Upload, 可同步的调用waitForUploadResult等待upload结束, 成功返回UploadResult, 失败抛出异常.
            long startTime = System.currentTimeMillis();
            Upload upload = transferManager.upload(putObjectRequest);
            showTransferProgress(upload);
            UploadResult uploadResult = upload.waitForUploadResult();
            long endTime = System.currentTimeMillis();
            System.out.println("used time: " + (endTime - startTime) / 1000);
            System.out.println(uploadResult.getETag());

        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transferManager.shutdownNow();
        cosclient.shutdown();
        return webappurl+key;
    }

    public static COSClient buildCosClient() {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(appkey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        // 3 生成cos客户端
        return new COSClient(cred, clientConfig);
    }


    public static void deleteCOSFile(String filePath){
        COSClient cosclient = buildCosClient();
        String key = filePath.replace(webappurl, "");
        cosclient.deleteObject(bucket, key);
    }

}
