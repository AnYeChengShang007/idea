package com.fjx.mybatis.dao;

import com.fjx.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDao implements IUserDao {
    private SqlSessionFactory factory;

    public UserDao(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> list = session.selectList("com.fjx.mybatis.dao.IUserDao.findAll");
        session.close();
        return list;
    }
}
