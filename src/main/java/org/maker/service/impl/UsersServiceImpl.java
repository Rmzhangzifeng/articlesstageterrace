package org.maker.service.impl;

import org.maker.dao.UsersMapper;
import org.maker.pojo.Users;
import org.maker.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public String loginCheck(Users users, HttpSession session) {
        List<Users> loginList = usersMapper.loginCheck(users);
        if(loginList!=null && loginList.size()>0){
            if(loginList.get(0).getUserpass().equals(users.getUserpass())){
                session.setAttribute("loginUserMsg",loginList.get(0));
                return "loginYes";
            }
        }
        return "loginNo";
    }
}
