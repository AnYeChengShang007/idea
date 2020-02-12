package com.fjx.crud.test;

import com.fjx.crud.dao.IUserDao;
import com.fjx.crud.domain.User;
import com.fjx.crud.domain.vo.QueryVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import java.io.InputStream;
import java.util.Date;
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
        IUserDao mapper = session.getMapper(IUserDao.class);
        List<User> all = mapper.findAll();
        for(User user:all){
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User user = mapper.findOne(41);
        System.out.println(user);
    }

    @Test
    public void testFindOne2(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("王");
        vo.setUser(user);
        List<User> all = mapper.findOne2(vo);
        for(User q:all){
            System.out.println(q);
        }
    }

    @Test
    public void testFindTotal(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        Integer total = mapper.findTotal();
        System.out.println(total);
    }

    @Test
    public void testFindByName(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        List<User> all = mapper.findByName("王");
        for(User user:all){
            System.out.println(user);
        }
    }
    @Test
    public void testAdd(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User user = new User();
        user.setBirthday(new Date());
        user.setUsername("add");
        user.setAddress("泰州");
        user.setSex("男");
        mapper.add(user);
        session.commit();
    }
    @Test
    public void testLastInsertId(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User user = new User();
        user.setBirthday(new Date());
        user.setUsername("add");
        user.setAddress("泰州");
        user.setSex("男");
        System.out.println(user);
        mapper.last_insert_id(user);
        System.out.println(user);
        session.commit();
    }
    @Test
    public void testUpdate(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User user = new User();
        user.setId(57);
        user.setBirthday(new Date());
        user.setUsername("add");
        user.setAddress("扬州");
        user.setSex("男");
        mapper.update(user);
        session.commit();
    }
    @Test
    public void testDelete(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        mapper.delete(58);
        session.commit();
    }

    @Test
    public void testFindByCondition(){
        session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User user = new User();
        User u = mapper.findByCondition(user);
        System.out.println(u);
    }


    @After
    public void after(){
        session.close();
    }
}
