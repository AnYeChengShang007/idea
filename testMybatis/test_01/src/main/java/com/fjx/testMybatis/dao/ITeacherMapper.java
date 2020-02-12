package com.fjx.testMybatis.dao;

import com.fjx.testMybatis.domain.Student;
import com.fjx.testMybatis.domain.Teacher;

import java.util.List;

public interface ITeacherMapper {

    public Teacher findById(Integer id);

    public List<Student> findStudents(Integer id);
}
