package com.blogger.user.springtest;

import com.blogger.user.domain.Boss;
import com.blogger.user.domain.Car;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

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

        // 获取defaultlistableBeanFactory
        DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) beanFactory;

        // 创建一个bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Boss.class);

        // 设置bean属性的依赖
        beanDefinitionBuilder.addPropertyReference("car", Car.BEAN_NAME_CAR);

        // 将bean注册到容器中
        listableBeanFactory.registerBeanDefinition("boss", beanDefinitionBuilder.getRawBeanDefinition());

    }
}
