package com.blogger.user.web;

import com.blogger.user.domain.User;
import com.blogger.user.service.CacheService;
import com.blogger.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-28 17:40
 * @desc
 * @since 1.8
 */

@RestController
public class LoginController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private CacheService cacheService;

    // 可以配置多个映射url
    @RequestMapping(value = {"/", "/index.html"})
    public ModelAndView loginPage() {

        return new ModelAndView("index");
    }

    @RequestMapping("/login.html")
    public String login(String username, String password) {

        String result = "";

        try {

            User user = this.userServiceImpl.updateUserLogin(username, password);

            if (user != null) {

                result = "login_succ";
            } else {

                result = "index";
            }
        } catch (Exception e) {

            logger.error("登录出错", e);
        }

        return result;
    }

    @RequestMapping("/cacheTest.action")
    public String cacheTest(HttpServletRequest request, String userName) throws Exception{

        User user = this.cacheService.getObj(userName);

        request.setAttribute("lastIp", user.getLastIp());

        User user1 = this.cacheService.getObj(userName);

        request.setAttribute("lastIp", user1.getLastIp());

        return "login_succ";
    }
}
