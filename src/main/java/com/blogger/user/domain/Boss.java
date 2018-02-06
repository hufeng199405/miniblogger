package com.blogger.user.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-02-06 21:26
 * @desc
 * @since 1.8
 */

public class Boss {

    private Car car;

    private List<String> fa;

    private String[] faArrays;

    private Map<String,Object> map;

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<String> getFa() {
        return fa;
    }

    public void setFa(List<String> fa) {
        this.fa = fa;
    }

    public String[] getFaArrays() {
        return faArrays;
    }

    public void setFaArrays(String[] faArrays) {
        this.faArrays = faArrays;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
