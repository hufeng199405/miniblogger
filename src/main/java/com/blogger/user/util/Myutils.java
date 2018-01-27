package com.blogger.user.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 类备注：工具类
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-22 22:34
 * @desc
 * @since 1.8
 */

public class Myutils {

    public static Date LocalDateTimeToUdate() {

        LocalDateTime localDateTime = LocalDateTime.now().withNano(0);

        ZoneId zone = ZoneId.systemDefault();

        Instant instant = localDateTime.atZone(zone).toInstant();

        return Date.from(instant);
    }
}
