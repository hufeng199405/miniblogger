package com.blogger.user.dao;

import com.blogger.user.domain.User;

/**
 * 类备注：用户dao接口
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-21 22:38
 * @desc
 * @since 1.8
 */

public interface UserDao {

    /**
     * 检查用户名和密码是否正确
     *
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    int getMatchCount(String userName, String password) throws Exception;

    /**
     * 根据用户名查询用户的信息
     *
     * @param userName
     * @return
     * @throws Exception
     */
    User findByUserName(String userName) throws Exception;

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    int updateLoginInfo(User user) throws Exception;
}
