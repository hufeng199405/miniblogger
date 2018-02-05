package com.blogger.user.springtest;

import com.blogger.user.domain.Car;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-02-02 17:17
 * @desc
 * @since 1.8
 */
public class MyinstantiationAwareBeanPostProcessor implements  InstantiationAwareBeanPostProcessor{

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        if(Car.BEAN_NAME_CAR.equals(beanName)){

            logger.info("car Bean调用自定义的postProcessBeforeInstantiation方法");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

        if(Car.BEAN_NAME_CAR.equals(beanName)){

            logger.info("car Bean调用自定义的postProcessAfterInstantiation方法");
        }
        return false;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        if(Car.BEAN_NAME_CAR.equals(beanName)){

            logger.info("car Bean调用自定义的postProcessPropertyValues方法");
        }

        MutablePropertyValues ms = (MutablePropertyValues) pvs;

        // 重新定义一个PropertyValue覆盖之前的
        PropertyValue newProperty = new PropertyValue("color", "yellow");

        ms.addPropertyValue(newProperty);

        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(Car.BEAN_NAME_CAR.equals(beanName)){

            logger.info("car Bean调用自定义的postProcessBeforeInitialization方法");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        /*if (Car.BEAN_NAME_CAR.equals(beanName)) {

            Car car = new Car();

            car.setId(10);
            car.setColor("black");

            logger.info("car Bean调用自定义的postProcessAfterInitialization方法");

            return car;
        } else {

            return bean;
        }*/
        if (Car.BEAN_NAME_CAR.equals(beanName)) {

            logger.info("car Bean调用自定义的postProcessAfterInitialization方法");
        }
        return null;
    }
}
