package com.blogger.user.service;

import com.blogger.user.domain.User;

/**
 * 类备注：用户service
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-22 21:53
 * @desc
 * @since 1.8
 */

public interface UserService {

    /**
     * 检查用户名和密码是否正确
     *
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    User updateUserLogin(String userName, String password) throws Exception;
}
