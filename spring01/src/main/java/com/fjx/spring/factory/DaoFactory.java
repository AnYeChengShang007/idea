package com.fjx.spring.factory;

import com.fjx.spring.dao.IUserDao;
import com.fjx.spring.dao.IUserDaoImpl;

public class DaoFactory {
    IUserDao getDao(){
        return new IUserDaoImpl();
    }
}
