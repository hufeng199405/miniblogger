package com.blogger.user.domain;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import java.util.Date;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-30 17:25
 * @desc
 * @since 1.8
 */
public class Car implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean{

    public static final String BEAN_NAME_CAR = "car";

    private Logger logger = Logger.getLogger(this.getClass());

    private Integer id;

    private String name;

    private String color;

    private Date buyTime;

    private String beanName;

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        this.beanFactory = beanFactory;
        logger.info("car Bean调用setBeanFactory方法设置beanFactory");
    }

    @Override
    public void setBeanName(String name) {

        this.beanName = name;
        logger.info("car Bean调用setBeanName方法设置beanName");
    }

    @Override
    public void destroy() throws Exception {

        this.beanName = name;
        logger.info("car Bean调用destroy方法销毁bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        this.beanName = name;
        logger.info("car Bean调用afterPropertiesSet初始化bean");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }
}
