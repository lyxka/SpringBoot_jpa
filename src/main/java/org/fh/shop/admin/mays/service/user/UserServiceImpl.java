package org.fh.shop.admin.mays.service.user;


import org.apache.commons.lang3.StringUtils;
import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.dao.user.IUserDao;
import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.fh.shop.admin.mays.model.requestSerach.UserSerach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名: UserServiceImpl
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 15:06
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Override
    public List<UserInfo> findAll(UserSerach userSerach) {
        //分页条件
        Pageable pageable = new PageRequest(userSerach.getStart()/userSerach.getLength() , userSerach.getLength());
        //组装条件
        Specification<UserInfo> specification = getUserSpecification(userSerach);
        //条件查询
        Page<UserInfo> page = this.userDao.findAll(specification, pageable);
        //组装结果 并返回
        List<UserInfo> content = page.getContent();
        return content;
    }

    @Override
    public ServiceResponse unlockUser(Integer id) {
        this.userDao.unlockUser(id);
        return ServiceResponse.success();
    }

    @Override
    public ServiceResponse addUser(UserInfo userInfo) {
        this.userDao.save(userInfo);
        return ServiceResponse.success();
    }

    @Override
    public ServiceResponse deleteAllUserInfo(List<Integer> idsList) {
        this.userDao.deleteAllUserInfo(idsList);
        return ServiceResponse.success();
    }

    @Override
    public ServiceResponse updateUserInfo(UserInfo userInfo) {
        this.userDao.save(userInfo);
        return ServiceResponse.success();
    }

    @Override
    public ServiceResponse updateUserDept(List<Integer> userIds, Integer deptId) {
        this.userDao.updateUserDept(userIds, deptId);
        return ServiceResponse.success();
    }


    /**
     * 构建条件查询 对象
     * @param userSerach
     * @return
     */
    public Specification<UserInfo> getUserSpecification(final UserSerach userSerach) {
        //条件查询
        return new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //两表联查
                root.join("deptInfo", JoinType.LEFT);
                //动态拼接条件
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotEmpty(userSerach.getUserName())) {
                    Predicate userName = cb.like(root.get("userName"), "%" + userSerach.getUserName() + "%");
                    predicates.add(userName);
                }
                if (userSerach.getMinBirthday() != null) {
                    Predicate minBirthday = cb.greaterThanOrEqualTo(root.get("birthday"), userSerach.getMinBirthday());
                    predicates.add(minBirthday);
                }
                if (userSerach.getMaxBirthday() != null) {
                    Predicate maxBirthday = cb.lessThanOrEqualTo(root.get("birthday"), userSerach.getMaxBirthday());
                    predicates.add(maxBirthday);
                }
                if (userSerach.getMinSalary() != null) {
                    Predicate minSalary = cb.greaterThanOrEqualTo(root.get("salary"), userSerach.getMinSalary());
                    predicates.add(minSalary);
                }
                if (userSerach.getMaxBirthday() != null) {
                    Predicate maxSalary = cb.lessThanOrEqualTo(root.get("salary"), userSerach.getMaxSalary());
                    predicates.add(maxSalary);
                }
                // 两表条件查询
                if (userSerach.getDeptIds() != null) {
                    CriteriaBuilder.In<Long> in = cb.in(root.get("deptInfo"));
                    List<Integer> deptIds = userSerach.getDeptIds();
                    for (int i = 0; i < deptIds.size(); i++) {
                        in.value((long) deptIds.get(i));
                    }
                    predicates.add(in);
                }
                Predicate[] predicate = predicates.toArray(new Predicate[predicates.size()]);
                return query.where(predicate).getRestriction();
            }
        };
    }
}
