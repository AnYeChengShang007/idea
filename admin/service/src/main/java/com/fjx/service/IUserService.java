package com.fjx.service;

import com.fjx.domain.Role;
import com.fjx.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService{

    public List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findAllRoleByUerId(String id);

    void addRoleToUser(String userId, String[] ids);
}
