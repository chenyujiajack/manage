package com.yu.ssm.dao;

import com.yu.ssm.domain.Permission;
import com.yu.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    //通过userid查询所有的Role
    @Select("select * from role where id in(select roleId from user_role where userId=#{userId})")
    @Results({
            @Result(id=true,column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yu.ssm.dao.IPermissionDao.findPermissionByRoleId")),
            //@Result(property = "roleName",column = "roleName")
    })
    List<Role> findRoleByUserId(String userId) throws Exception;


}
