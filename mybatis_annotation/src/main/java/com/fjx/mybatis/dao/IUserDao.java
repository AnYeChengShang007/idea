package com.fjx.mybatis.dao;

import com.fjx.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    public List<User> findAll();

}
