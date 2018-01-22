package com.blogger.user.dao;

import com.blogger.user.domain.UserLogInLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-22 22:00
 * @desc
 * @since 1.8
 */

public interface UserLogInLogDao {

    int insertUserLogDaoRecord(UserLogInLog userLogInLog) throws Exception;
}
