package com.yu.ssm.dao;

import com.yu.ssm.domain.Role;
import com.yu.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where username=#{userName} ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",javaType = java.util.List.class,many =@Many(select="com.yu.ssm.dao.IRoleDao.findRoleByUserId"))
    })
     UserInfo findByUserName(String userName) throws Exception;




}