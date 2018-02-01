package com.blogger.user.web;

import com.blogger.user.service.impl.UserServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;

import javax.sql.rowset.spi.XmlReader;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-02-01 17:31
 * @desc
 * @since 1.8
 */
public class FactoryBeanTest {

    @Test
    public void factoryTest() throws Exception{

        // 加载xml资源
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = resourcePatternResolver.getResources(PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+"spring.xml");

        Resource resource = resources[0];

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // 创建一个bean write
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(factory);

        // 加载资源文件
        xmlReader.loadBeanDefinitions(resource);

        // 从factory中获取bean
        UserServiceImpl userServiceImpl = factory.getBean("userServiceImpl", UserServiceImpl.class);

        System.out.println(userServiceImpl.toString());

        /*BasicDataSource userServiceImpl1 = factory.getBean("jdbcTemplate", BasicDataSource.class);

        System.out.println(userServiceImpl1.toString());*/
    }
}
