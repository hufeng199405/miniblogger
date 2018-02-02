package com.blogger.user.web;

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
        return null;
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

        if(Car.BEAN_NAME_CAR.equals(beanName)){

            logger.info("car Bean调用自定义的postProcessAfterInitialization方法");
        }
        return null;
    }
}
