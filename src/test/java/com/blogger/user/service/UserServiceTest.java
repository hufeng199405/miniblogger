package com.blogger.user.service;

import com.blogger.user.domain.User;
import com.blogger.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * 类备注：测试
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-23 23:50
 * @desc 整合testng测试
 * @since 1.8
 */

@ContextConfiguration("classpath*:spring.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserService userServiceImpl;

    @Test
    public void userLogin() throws Exception {

        String userName = "hufeng";
        String password = "123";

        User user = this.userServiceImpl.updateUserLogin(userName, password);

        System.out.println(user.getLastIp());
    }
}
