package org.fh.shop.admin.mays.web.action.dept;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.po.dept.DeptInfo;
import org.fh.shop.admin.mays.model.responseUser.DeptResponse;
import org.fh.shop.admin.mays.service.dept.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名: DeptController
 * 描述：
 *
 * @author
 * @create 2019-03-03 14:26
 **/
@Controller
@RequestMapping("/dept/")
public class DeptController {
    @Resource
    private DeptService deptService;

    @RequestMapping("initDeptList")
    @ResponseBody
    public ServiceResponse initDeptList() {
        List<DeptInfo> list = deptService.initDeptList();
        List<DeptResponse> deptResponseList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            DeptInfo deptInfo = list.get(i);
            DeptResponse deptResponse = new DeptResponse();
            deptResponse.setId(deptInfo.getId());
            deptResponse.setPid(deptInfo.getPid());
            deptResponse.setName(deptInfo.getIndustryTitle());
            deptResponse.setRemark(deptInfo.getRemark());
            deptResponseList.add(deptResponse);
        }
        return ServiceResponse.success(deptResponseList);
    }

    @RequestMapping("addDeptInfo")
    @ResponseBody
    public ServiceResponse addDeptInfo(DeptInfo deptInfo){
        return deptService.addDeptInfo(deptInfo);
    }

    @RequestMapping("updateDeptInfo")
    @ResponseBody
    public ServiceResponse updateDeptInfo(DeptInfo deptInfo){
        return deptService.updateDeptInfo(deptInfo);
    }


    @RequestMapping("deleteDeptInfo")
    @ResponseBody
    public ServiceResponse deleteDeptInfo(String ids){
        List<Integer> list = new ArrayList<>();
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        return deptService.deleteDeptInfo(list);
    }
}
