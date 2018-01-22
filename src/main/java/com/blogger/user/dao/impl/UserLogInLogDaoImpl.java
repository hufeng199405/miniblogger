package com.blogger.user.dao.impl;

import com.blogger.user.dao.UserLogInLogDao;
import com.blogger.user.domain.UserLogInLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-22 22:03
 * @desc
 * @since 1.8
 */

@Repository
public class UserLogInLogDaoImpl implements UserLogInLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertUserLogDaoRecord(UserLogInLog userLogInLog) throws Exception {

        String sql = "insert into user_login_record(?,?,?,?)";

        Object[] objects = new Object[]{userLogInLog.getLoginId(), userLogInLog.getUserId(), userLogInLog.getIp(), userLogInLog.getLoginTime()};

        return jdbcTemplate.update(sql, objects);
    }
}
