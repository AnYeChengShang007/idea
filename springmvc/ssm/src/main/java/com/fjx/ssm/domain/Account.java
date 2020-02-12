package com.fjx.ssm.domain;

import java.io.Serializable;

public class Account implements Serializable {
    Integer id;
    String username;
    Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }
}
