package com.fjx.crud.dao;

import com.fjx.crud.domain.User;
import com.fjx.crud.domain.vo.QueryVo;

import java.util.List;

public interface IUserDao {
    public List<User> findAll();
    public User findOne(Integer id);
    public List<User> findOne2(QueryVo vo);
    public Integer findTotal();
    public List<User> findByName(String name);
    public void add(User user);
    public void update(User user);
    public void delete(Integer id);
    public void last_insert_id(User user);
    public User findByCondition(User user);

}
