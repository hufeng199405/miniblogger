package com.blogger.user.web;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-02-06 17:35
 * @desc
 * @since 1.8
 */
public class MainTest {

    Logger logger = Logger.getLogger(this.getClass());

    @Test
    private void mytest() {

        String aa =  "fdsfsd$sdf";

        logger.info(aa.split("\\$")[0]);
    }
}
