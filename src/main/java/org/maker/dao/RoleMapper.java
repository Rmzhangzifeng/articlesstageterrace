package org.maker.dao;

import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Users;

import java.util.List;

public interface RoleMapper {
    long queryUser(Users user);

    List<Users> queryUserPage(@Param("start") int start,@Param("end") int end,@Param("user") Users user);

    List queryRole();

    Users queryRoles(Users user);

    int updateRole(Users user);
}
