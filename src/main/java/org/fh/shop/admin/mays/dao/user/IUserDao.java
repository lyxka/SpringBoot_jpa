/** 
 * <pre>项目名称:lalal 
 * 文件名称:IUserDao.java 
 * 包名:org.fh.shop.admin.mays.dao.user 
 * 创建日期:2019年1月31日下午11:12:58 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package org.fh.shop.admin.mays.dao.user;

import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <pre>项目名称：lalal    
 * 类名称：IUserDao    
 * 类描述：    
 * 创建人：马优生 178249290@qq.com    
 * 创建时间：2019年1月31日 下午11:12:58    
 * 修改人：马优生 178249290@qq.com    
 * 修改时间：2019年1月31日 下午11:12:58    
 * 修改备注：       
 * @version </pre>    
 */
public interface IUserDao extends JpaRepository<UserInfo,Integer>,JpaSpecificationExecutor<UserInfo> {

    @EntityGraph(value = "User.Graph", type = EntityGraph.EntityGraphType.FETCH)
    Page<UserInfo> findAll(Specification<UserInfo> specification, Pageable pageable);

    @Modifying
    @Query("update UserInfo set stauts = 0 where id = :id")
    void unlockUser(@Param("id") Integer id);

    @Modifying
    @Query("delete from UserInfo where id in (:idsList)")
    void deleteAllUserInfo(@Param("idsList") List<Integer> idsList);

    @Modifying
    @Query("update UserInfo set deptId = :deptId where id in (:userIds)")
    void updateUserDept(@Param("userIds") List<Integer> userIds, @Param("deptId")Integer deptId);
}
