package org.fh.shop.admin.mays.service.dept;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.po.dept.DeptInfo;

import java.util.List;

/**
 * 类名: DeptService
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 19:47
 */

public interface DeptService {
    List<DeptInfo> initDeptList();

    ServiceResponse addDeptInfo(DeptInfo deptInfo);

    ServiceResponse updateDeptInfo(DeptInfo deptInfo);

    ServiceResponse deleteDeptInfo(List<Integer> idsList);
}
