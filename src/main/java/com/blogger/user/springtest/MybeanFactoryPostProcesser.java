package com.blogger.user.springtest;

import com.blogger.user.domain.Car;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-02-05 13:53
 * @desc
 * @since 1.8
 */
public class MybeanFactoryPostProcesser implements BeanFactoryPostProcessor {

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition bean = beanFactory.getBeanDefinition(Car.BEAN_NAME_CAR);

        bean.getPropertyValues().addPropertyValue("color", "red");

        logger.info("调用工厂定义信息后置处理器修改color为red");
    }
}
