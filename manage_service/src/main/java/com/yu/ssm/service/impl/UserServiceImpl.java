package com.yu.ssm.service.impl;


import com.yu.ssm.dao.IUserDao;
import com.yu.ssm.domain.Role;
import com.yu.ssm.domain.UserInfo;
import com.yu.ssm.service.IUserService;
import com.yu.ssm.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserInfo userInfo = null;
        try {
            userInfo=userDao.findByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()) );

        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list =new ArrayList<>();
        for(Role role:roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }




}