package org.fh.shop.admin.mays.dao.dept;

import org.fh.shop.admin.mays.model.po.dept.DeptInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 类名: DeptDao
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 20:25
 */

public interface DeptDao extends JpaRepository<DeptInfo,Integer>,JpaSpecificationExecutor<DeptInfo> {
    @Modifying
    @Query("delete from DeptInfo where id in (:idsList)")
    void deleteDeptInfo(@Param("idsList") List<Integer> idsList);
}
