package com.blogger.user.dao.impl;

import com.blogger.user.dao.UserDao;
import com.blogger.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 类备注：用户dao实现
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-21 22:44
 * @desc
 * @since 1.8
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 检查用户名和密码是否正确
     *
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public int getMatchCount(String userName, String password) throws Exception {

        return this.jdbcTemplate.queryForObject(" select count(0) from user_record where user_name = ? and password = ?", Integer.class);
    }

    public User findByUserName(String userName) throws Exception {

        String sql = "select * from user_record where user_name = ?";

        return this.jdbcTemplate.queryForObject(sql, User.class);
    }

    public int updateLoginInfo(User user) throws Exception {

        String sql = "update user_record set credits = ?,last_visit = ? , last_ip = ? where user_id = ?";

        Object object = new Object[]{user.getCredits(), user.getLastVisit(), user.getLastIp(), user.getUserId()};

        return this.jdbcTemplate.update(sql, object);
    }
}
