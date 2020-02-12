package com.fjx.mybatis.test;

import com.fjx.mybatis.dao.IUserDao;
import com.fjx.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        InputStream in = Test.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        List<User> all = mapper.findAll();
        for (User user:all) {
            System.out.println(user);
        }


    }
}
