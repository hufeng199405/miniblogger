package com.blogger.user.web;

import com.blogger.user.domain.Car;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-02-05 17:32
 * @desc
 * @since 1.8
 */
public class ReflectTest {

    Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void myReflectTest() throws Exception {

        Class car = Car.class;

        Field[] field = car.getDeclaredFields();

        Constructor<Car> constructor = car.getConstructor();

        constructor.setAccessible(true);

        Car carInst = constructor.newInstance();

        for (Field f : field) {

            // 取消java语言检查
            f.setAccessible(true);

            if (f.getName() == "id") {

                f.set(carInst, 110);
                logger.info(carInst.getId());
            }

            if (f.getName() == "name") {

                f.set(carInst, "hufeng");
                logger.info(carInst.getName());
            }
        }
    }
}
