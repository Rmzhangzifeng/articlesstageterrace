package org.maker.service;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Users;

import java.util.List;

public interface RoleService {
    JSONObject queryUser(Users user, int page, int rows);

    List queryRole();

    Users queryRoles(Users user);

    int updateRole(Users user);
}
