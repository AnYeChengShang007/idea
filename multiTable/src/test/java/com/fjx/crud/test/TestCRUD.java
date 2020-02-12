package com.fjx.crud.test;

import com.fjx.crud.dao.IAccountDao;
import com.fjx.crud.dao.IUserDao;
import com.fjx.crud.domain.Account;
import com.fjx.crud.domain.AccountUser;
import com.fjx.crud.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestCRUD {

    private SqlSessionFactory factory;
    private SqlSession session;

    @Before
    public void before(){
        InputStream in = TestCRUD.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }

    @Test
    public void testFindAll(){
        session = factory.openSession();
        IAccountDao mapper = session.getMapper(IAccountDao.class);
        List<Account> all = mapper.findAll();
        for(Account account:all){
            System.out.println(account);
        }
    }

    @Test
    public void testFindAll2(){
        session = factory.openSession();
        IAccountDao mapper = session.getMapper(IAccountDao.class);
        List<AccountUser> all = mapper.findAll2();
        for(AccountUser account:all){
            System.out.println(account);
        }
    }

    @Test
    public void testFindAll3(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        List<User> all = mapper.findAll2();
        for(User account:all){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User user = mapper.findOne(41);
        System.out.println(user);
    }

    @After
    public void after(){
        session.close();
    }
}
