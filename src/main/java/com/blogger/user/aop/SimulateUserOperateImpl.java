package com.blogger.user.aop;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-10 17:13
 * @desc
 * @since 1.8
 */
@Component
public class SimulateUserOperateImpl implements SimulateUserOperate {

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void deleteUser(String name) throws Exception {

        logger.info("正在删除用户中");
    }

    @Override
    public void updateUser(String name) throws Exception {

        logger.info("正在修改用户中");
    }
}
