package com.fjx.spring.service;

import com.fjx.spring.dao.IUserDao;
import com.fjx.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service("UserService")
public class UserService {

    @Resource(name="userDao")
    IUserDao dao = null;

    public void save(User user) throws SQLException{
        dao.save(user);
    }

    public List<User> findAll() throws SQLException{
        return dao.findAll();
    }

    public User findOne(int id) throws SQLException{
        return dao.findOne(id);
    }

    public void update(User user) throws SQLException{
        dao.update(user);
    }

    public void delete(int id) throws SQLException{
        dao.delete(id);
    }


}
