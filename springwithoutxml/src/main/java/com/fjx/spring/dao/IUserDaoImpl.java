package com.fjx.spring.dao;

import com.fjx.spring.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class IUserDaoImpl implements IUserDao {

    @Autowired
    QueryRunner runner = null;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void save(User user) throws SQLException {
        runner.insert("insert into user(username,birthday,sex,address) values (?,?,?,?)",new BeanHandler<User>(User.class),user.getUsername(),user.getBirthday(),user.getSex(),user.getAddress());
    }

    public List<User> findAll() throws SQLException {
        return runner.query("select * from user",new BeanListHandler<User>(User.class));
    }

    public User findOne(int id) throws SQLException {
        return runner.query("select * from user where id=?",new BeanHandler<User>(User.class),id);
    }

    public void update(User user) throws SQLException {
        runner.update("update user set username=?,birthday=?,sex=?,address=? where id=?",user.getUsername(),user.getBirthday(),user.getSex(),user.getAddress(),user.getId());

    }

    public void delete(int id) throws SQLException {
        runner.update("delete from user where id=?",id);
    }
}
