package com.fjx.testdi.pojo;

import java.util.*;

public class User {
    String name;
    List<String> list;
    Map<String,String> map;
    Set<String> set;
    Properties properties;
    Address address;
    String[] books;
    String wife;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", properties=" + properties +
                ", address=" + address +
                ", books=" + Arrays.toString(books) +
                ", wife='" + wife + '\'' +
                '}';
    }
}
