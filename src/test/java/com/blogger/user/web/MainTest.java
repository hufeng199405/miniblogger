package com.blogger.user.web;

import com.blogger.user.aop.SimulateUserOperate;
import com.blogger.user.aop.SimulateUserOperateImpl;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
    private void mytest() throws Exception {

        /*String aa =  "1m² < X <= 10m²";

        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(aa);

        while(matcher.find()){

            logger.info(matcher.group());
        }*/
        /*BigDecimal bigDecimal = BigDecimal.valueOf(0.05);
        BigDecimal bigDecimal1 = new BigDecimal(0.05);

        logger.info(bigDecimal.add(BigDecimal.valueOf(5)));
        logger.info(bigDecimal1.add(BigDecimal.valueOf(5)));*/

        SimulateUserOperate simulateUserOperate = new SimulateUserOperateImpl();

        SimulateUserOperate test = (SimulateUserOperate) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{SimulateUserOperate.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                logger.info("运行方法前------------");

                Object object = method.invoke(simulateUserOperate, args);

                logger.info("运行方法后--------------");

                return object;
            }
        });

        test.deleteUser("test");
    }
}
