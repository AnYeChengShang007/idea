package com.fjx.testdi.pojo;

public class Address {
    String addName;

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addName='" + addName + '\'' +
                '}';
    }
}
