package com.fjx.testMybatis.demo;

import com.fjx.testMybatis.dao.IStudentMapper;
import com.fjx.testMybatis.dao.ITeacherMapper;
import com.fjx.testMybatis.domain.Student;
import com.fjx.testMybatis.domain.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo01 {
    SqlSessionFactory factory;

    @Before
    public void before(){
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll(){
        SqlSession sqlSession = factory.openSession();
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        List<Student> all = mapper.findAll();
        for (Student student : all) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testFindTeacher(){
        SqlSession sqlSession = factory.openSession();
        ITeacherMapper mapper = sqlSession.getMapper(ITeacherMapper.class);
        Teacher teacher = mapper.findById(1);
        System.out.println(teacher);

    }
}
