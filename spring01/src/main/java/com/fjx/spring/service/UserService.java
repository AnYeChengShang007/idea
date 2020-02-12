package com.fjx.spring.service;

import com.fjx.spring.dao.IUserDao;

public class UserService {
    IUserDao dao = null;

    public IUserDao getDao() {
        return dao;
    }

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

    public void save(){
        dao.save();
    }
}
