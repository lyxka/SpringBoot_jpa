package org.fh.shop.admin.mays.dao.dept;

import org.fh.shop.admin.mays.model.po.dept.DeptInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IDeptDao extends JpaRepository<DeptInfo,Integer>,JpaSpecificationExecutor<DeptInfo> {

}
