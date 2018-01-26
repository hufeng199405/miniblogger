package com.blogger.user.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 类备注：用戶信息表实体
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-21 22:23
 * @desc
 * @since 1.8
 */

public class User implements Serializable {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 积分
     */
    private Integer credits;

    /**
     * 最后一次登录时间
     */
    private Date lastVisit;

    /**
     * 最后一次登录IP
     */
    private String lastIp;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }
}
