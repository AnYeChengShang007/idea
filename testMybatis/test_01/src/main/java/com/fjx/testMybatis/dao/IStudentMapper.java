package com.fjx.testMybatis.dao;

import com.fjx.testMybatis.domain.Student;
import com.fjx.testMybatis.domain.Teacher;

import java.util.List;

public interface IStudentMapper {

    public List<Student> findAll();

    public Student findById(int id);

    public Teacher findTeacherById(int id);
}
