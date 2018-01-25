package org.maker.dao;


import org.maker.pojo.Users;

import java.util.List;

public interface UsersMapper {
    List<Users> loginCheck(Users users);
}