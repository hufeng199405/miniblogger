package com.blogger.user.web;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        /*String aa =  "1m² < X <= 10m²";

        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(aa);

        while(matcher.find()){

            logger.info(matcher.group());
        }*/
        BigDecimal bigDecimal = BigDecimal.valueOf(0.05);
        BigDecimal bigDecimal1 = new BigDecimal(0.05);

        logger.info(bigDecimal.add(BigDecimal.valueOf(5)));
        logger.info(bigDecimal1.add(BigDecimal.valueOf(5)));
    }
}
