package com.blogger.user.aop;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-10 17:13
 * @desc
 * @since 1.8
 */
public interface SimulateUserOperate {

    /**
     * 模拟删除用户
     *
     * @param name
     * @throws Exception
     */
    void deleteUser(String name) throws Exception;

    /**
     * 模拟修改用户
     *
     * @param name
     * @throws Exception
     */
    void updateUser(String name) throws Exception;
}
