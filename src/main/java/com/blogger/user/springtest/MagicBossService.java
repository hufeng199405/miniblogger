package com.blogger.user.springtest;

import com.blogger.user.domain.Car;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-03-02 17:21
 * @desc
 * @since 1.8
 */
@Service
public class MagicBossService {

    //@Resource(name = "magicBoss")
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
