package test;

import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.fh.shop.admin.mays.model.requestSerach.UserSerach;
import org.fh.shop.admin.mays.service.user.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名: JPAtest
 * 描述：
 *
 * @author MYS
 * @create 2019-04-02 14:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-common.xml")
public class JPAtest {
    @Resource
    private IUserService userService;

    @Test
    public void findAllTest(){
        UserSerach userSerach = new UserSerach();
//        userSerach.setMinBirthday(new Date());
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(15);
        userSerach.setDeptIds(list);
        List<UserInfo> all = userService.findAll(userSerach);
        all.forEach(x -> System.out.println(x));
    }
}
