package org.maker.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.maker.dao.RoleMapper;
import org.maker.pojo.Messagers;
import org.maker.pojo.Picgroup;
import org.maker.pojo.Role;
import org.maker.pojo.Users;
import org.maker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public JSONObject queryUser(Users user, int page, int rows) {
        long count;
        List<Users> list;
        int start=(page-1)*rows;
        int end=start+rows;
        count=roleMapper.queryUser(user);
        list=roleMapper.queryUserPage(start,end,user);
        JSONObject json=new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public List queryRole() {
        return roleMapper.queryRole();
    }

    @Override
    public Users queryRoles(Users user) {
        return roleMapper.queryRoles(user);
    }

    @Override
    public int updateRole(Users user) {
        return roleMapper.updateRole(user);
    }

    @Override
    public JSONObject queryMessagerByMy(Messagers messagers, int page, int rows) {
        long count;
        List<Messagers> list;
        int start=(page-1)*rows;
        int end=start+rows;
        count=roleMapper.queryMessagerByMy(messagers);
        list=roleMapper.queryMessagerByMyPage(start,end,messagers);
        JSONObject json=new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public List queryUsers(Users u) {
        return roleMapper.queryUsers(u);
    }

    @Override
    public int updateUser(Users user) {
        return roleMapper.updateUser(user);
    }
}
