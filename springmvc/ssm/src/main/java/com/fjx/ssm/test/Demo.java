package com.fjx.ssm.test;

import com.fjx.ssm.dao.IAccountDao;
import com.fjx.ssm.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {

    @Test
    public void test() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = bulider.build(in);
        SqlSession session = factory.openSession();
        IAccountDao mapper = session.getMapper(IAccountDao.class);
        List<Account> all = mapper.findAll();
        System.out.println(all);
        Account a = new Account();
        a.setUsername("王五");
        a.setMoney(60f);
        mapper.save(a);
        session.commit();
        session.close();
    }
}
