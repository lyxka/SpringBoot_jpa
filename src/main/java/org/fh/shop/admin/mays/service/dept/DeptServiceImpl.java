package org.fh.shop.admin.mays.service.dept;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.dao.dept.DeptDao;
import org.fh.shop.admin.mays.model.po.dept.DeptInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类名: DeptServiceImpl
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 19:47
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;
    @Override
    public List<DeptInfo> initDeptList() {
        List<DeptInfo> all = deptDao.findAll();
        return all;
    }

    @Override
    public ServiceResponse addDeptInfo(DeptInfo deptInfo) {
        this.deptDao.save(deptInfo);
        return ServiceResponse.success(deptInfo.getId());
    }

    @Override
    public ServiceResponse updateDeptInfo(DeptInfo deptInfo) {
        this.deptDao.save(deptInfo);
        return ServiceResponse.success();
    }

    @Override
    public ServiceResponse deleteDeptInfo(List<Integer> idsList) {
        this.deptDao.deleteDeptInfo(idsList);
        return ServiceResponse.success();
    }
}
