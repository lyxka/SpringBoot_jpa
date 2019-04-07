/**
 * <pre>项目名称:lalal
 * 文件名称:UserInfo.java
 * 包名:org.fh.shop.admin.mays.web.action
 * 创建日期:2019年1月31日下午11:06:46
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package org.fh.shop.admin.mays.web.action.user;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.fh.shop.admin.mays.model.requestSerach.UserSerach;
import org.fh.shop.admin.mays.model.responseUser.UserResponse;
import org.fh.shop.admin.mays.service.user.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>项目名称：lalal
 * 类名称：UserInfo
 * 类描述：
 * 创建人：马优生 178249290@qq.com
 * 创建时间：2019年1月31日 下午11:06:46
 * 修改人：马优生 178249290@qq.com
 * 修改时间：2019年1月31日 下午11:06:46
 * 修改备注：
 * @version </pre>
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("toUserPage")
    public String toUserPage(){
        return "user/userList";
    }


    /**
     * 查询
     * @param userSerach
     * @return
     */
    @RequestMapping("findUserList")
    @ResponseBody
    public ServiceResponse findUserList(UserSerach userSerach, @RequestParam("ids[]") List<Integer> list){
        userSerach.setDeptIds(list);
        List<UserInfo> all = userService.findAll(userSerach);
        List<UserResponse> responseList = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            UserInfo userInfo = all.get(i);
            UserResponse userResponse = new UserResponse();
            userResponse.setId(userInfo.getId());
            userResponse.setRecordsTotal(all.size());
            userResponse.setRecordsFiltered(all.size());
            userResponse.setIndustryTitle(userInfo.getDeptInfo().getIndustryTitle());
            userResponse.setDraw(userSerach.getDraw());
            userResponse.setUserName(userInfo.getUserName());
            userResponse.setBirthday(userInfo.getBirthday());
            userResponse.setImagePath(userInfo.getImagePath());
            userResponse.setUserRealName(userInfo.getUserRealName());
            userResponse.setLoginDate(userInfo.getLoginDate());
            userResponse.setStauts(userInfo.getStauts());
            responseList.add(userResponse);
        }
        return ServiceResponse.success(responseList);
    }

    @RequestMapping("unlockUser")
    @ResponseBody
    public ServiceResponse unlockUser(Integer id) {
        return userService.unlockUser(id);
    }

    @RequestMapping("addUser")
    @ResponseBody
    public ServiceResponse addUser(UserInfo userInfo){
        return userService.addUser(userInfo);
    }


    @RequestMapping("deleteAllUserInfo")
    @ResponseBody
    public ServiceResponse deleteAllUserInfo(String idsList){
        String[] split = idsList.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        return userService.deleteAllUserInfo(list);
    }


    @RequestMapping("updateUserInfo")
    @ResponseBody
    public ServiceResponse updateUserInfo(UserInfo userInfo){
        return userService.updateUserInfo(userInfo);
    }

    @RequestMapping("updateUserDept")
    @ResponseBody
    public ServiceResponse updateUserDept(String userIds, Integer deptId){
        String[] split = userIds.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        return userService.updateUserDept(list, deptId);
    }
}
