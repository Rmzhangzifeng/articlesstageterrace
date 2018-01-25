package org.maker.service;

import org.maker.pojo.Users;

import javax.servlet.http.HttpSession;

public interface UsersService {
    String loginCheck(Users users,HttpSession session);
}
