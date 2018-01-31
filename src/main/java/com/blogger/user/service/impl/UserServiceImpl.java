package com.blogger.user.service.impl;

import com.blogger.user.dao.UserDao;
import com.blogger.user.dao.UserLogInLogDao;
import com.blogger.user.domain.User;
import com.blogger.user.domain.UserLogInLog;
import com.blogger.user.service.UserService;
import com.blogger.user.util.Myutils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-22 21:55
 * @desc
 * @since 1.8
 */

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDaoImpl;

    @Autowired
    private UserLogInLogDao userLogInLogDaoImpl;

    @Transactional
    public User updateUserLogin(String userName, String password) throws Exception {

        User user = null;

        try {

            // 1、验证账户的有效性
            int count = this.userDaoImpl.getMatchCount(userName, password);

            if (count <= 0) {

                this.logger.error("账户密码不正确！");
                return null;
            }

            // 查询当前的用户信息
            user = this.userDaoImpl.findByUserName(userName);

            // 给当前用户加上5分
            user.setCredits((user.getCredits() == null ? 0 : user.getCredits()) + 5);
            // 更新最后登录相关状态
            user.setLastIp("暂时为空");

            user.setLastVisit(Myutils.LocalDateTimeToUdate());

            // 2、给当前客户增加积分
            this.userDaoImpl.updateLoginInfo(user);

            UserLogInLog userLogInLog = new UserLogInLog();

            // 登录主键
            userLogInLog.setLoginId(3);
            // 登录时间
            userLogInLog.setLoginTime(Myutils.LocalDateTimeToUdate());
            // 登录ip
            userLogInLog.setIp("暂时为空");
            // 登录用户ids
            userLogInLog.setUserId(user.getUserId());

            // 3、添加登录记录
            this.userLogInLogDaoImpl.insertUserLogDaoRecord(userLogInLog);
        } catch (Exception e) {

            logger.error("事务出错", e);
        }

        return user;
    }
}
