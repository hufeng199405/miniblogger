package com.blogger.user.aop;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-10 17:33
 * @desc
 * @since 1.8
 */
@Component
public class SimulateUserNoInteface {

    Logger logger = Logger.getLogger(this.getClass());

    public void deleteUser(String name) throws Exception {

        logger.info("正在删除用户中");
    }

    public void updateUser(String name) throws Exception {

        logger.info("正在修改用户中");
    }
}
