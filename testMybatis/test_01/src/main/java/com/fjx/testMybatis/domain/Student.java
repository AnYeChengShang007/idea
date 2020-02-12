package com.fjx.testMybatis.domain;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String sname;
    int tid;
    Teacher teacher;

    public Student() {
    }

    public Student(int id, String sname, int tid, Teacher teacher) {
        this.id = id;
        this.sname = sname;
        this.tid = tid;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", tid=" + tid +
                ", teacher=" + teacher +
                '}';
    }
}
