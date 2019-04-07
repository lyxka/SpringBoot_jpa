package org.fh.shop.admin.mays.service.user;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.fh.shop.admin.mays.model.requestSerach.UserSerach;

import java.util.List;

/**
 * 类名: IUserService
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 15:06
 */

public interface IUserService {
    List<UserInfo> findAll(UserSerach userSerach);

    ServiceResponse unlockUser(Integer id);

    ServiceResponse addUser(UserInfo userInfo);

    ServiceResponse deleteAllUserInfo(List<Integer> idsList);

    ServiceResponse updateUserInfo(UserInfo userInfo);

    ServiceResponse updateUserDept(List<Integer> userIds, Integer deptId);

}
