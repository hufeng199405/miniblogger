package com.blogger.user.dao.impl;

import com.blogger.user.dao.Userdao;
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
public class UserdaoImpl implements Userdao {

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

        this.jdbcTemplate.queryfor
        return 0;
    }

    public User findByUserName(String userName) throws Exception {
        return null;
    }

    public int updateLoginInfo(Integer userId) throws Exception {
        return 0;
    }
}
