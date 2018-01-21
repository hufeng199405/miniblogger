package com.blogger.user.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 类备注：用户登录日志
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-21 22:34
 * @desc
 * @since 1.8
 */

public class UserLogInLog implements Serializable {

    /**
     * 主键id
     */
    private Integer loginId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 登录Ip
     */
    private String ip;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
