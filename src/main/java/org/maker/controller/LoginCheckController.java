package org.maker.controller;


import org.maker.pojo.Users;
import org.maker.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 平台登陆controller
 */
@Controller
public class LoginCheckController {

    @Autowired
    private UsersService usersService;

    /**
     * 登陆验证
     * @return  登陆验证结果信息
     */
    @RequestMapping("/loginCheck")
    @ResponseBody
    public Object loginCheck(Users users, HttpSession session){
        String loginFlag = new String();
        loginFlag = usersService.loginCheck(users,session);
        return loginFlag;
    }

    /**
     * 登陆成功跳转到管理页面
     * @return
     */
    @RequestMapping("/loginYes/firstShow")
    public String firstShow(){
        return "index";
    }

}
