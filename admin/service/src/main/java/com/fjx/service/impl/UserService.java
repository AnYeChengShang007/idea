package com.fjx.service.impl;

import com.fjx.dao.IUserDao;
import com.fjx.domain.Role;
import com.fjx.domain.UserInfo;
import com.fjx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserDao dao;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        dao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Role> findAllRoleByUerId(String id) {
        return dao.findAllRoleByUserId(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for(String id:ids){
            dao.addRoleToUser(userId,id);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = dao.findByUsername(username);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),getAuthoritiesByRoles(userInfo.getRoles()));
        return user;
    }

    private List<GrantedAuthority> getAuthoritiesByRoles(List<Role> roles){
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }
}
