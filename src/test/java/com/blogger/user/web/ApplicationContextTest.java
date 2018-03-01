package com.blogger.user.web;

import com.blogger.user.domain.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-02-05 13:42
 * @desc
 * @since 1.8
 */
public class ApplicationContextTest {

    @Test
    public void applicationTest() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "spring-application-car.xml");

        BeanFactory factory = (applicationContext.getParent() instanceof ConfigurableApplicationContext) ?
                ((ConfigurableApplicationContext) applicationContext.getParent()).getBeanFactory() : applicationContext.getParent();

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(factory);

        beanFactory.ignoreDependencyInterface(BeanFactoryAware.class);

        Car car = applicationContext.getBean("car", Car.class);

        System.out.print(car.getColor());
    }
}
