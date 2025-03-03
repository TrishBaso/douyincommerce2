package org.example.douyincommerce.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.example.douyincommerce.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import jakarta.servlet.http.*;
import java.util.HashMap;
import java.util.Map;


@RestController
public class LoginController {
    @Resource
    UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map<String, Object> login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpSession session) {
        Map<String, Object> login = userService.getLogin(username, password);
        Map<String, Object> map = new HashMap<>();
        if (username!=null && !"".equals(username) && password!=null && !"".equals(password)) {
            session.setAttribute("login", login);
            if (login != null) {
                StpUtil.login(login.get("id"));
                login.put("satoken", StpUtil.getTokenInfo());
                map.put("code", 200);
                map.put("msg", "登录成功");
                map.put("data", login);
            } else {
                map.put("code", 201);
                map.put("msg", "登录失败");
                map.put("data", "error");
            }
        }
        return map;
    }

}
