package com.fjx.testMybatis.domain;

import java.io.Serializable;
import java.util.List;

public class Teacher implements Serializable{
    int id;
    String tname;
    List<Student> students;

    public Teacher() {
    }

    public Teacher(int id, String tname, List<Student> students) {
        this.id = id;
        this.tname = tname;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", students=" + students +
                '}';
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
