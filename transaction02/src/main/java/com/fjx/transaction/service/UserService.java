package com.fjx.transaction.service;

import com.fjx.transaction.dao.IAccountDao;
import com.fjx.transaction.domain.Account;
import com.fjx.transaction.utils.TransactionManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service("userService")
public class UserService implements IUserService {

    @Resource(name="dao")
    private IAccountDao dao;

    @Resource(name="tm")
    private TransactionManager tm;

    public void transfer(String from, String to, float money) {
        try {
            tm.begin();
            Account f = dao.findByName(from);
            Account t = dao.findByName(to);
            f.setMoney(f.getMoney()-money);
            t.setMoney(t.getMoney()+money);
            updateMoney(f);
            updateMoney(t);
            tm.commit();
        } catch (Exception e) {
            tm.rollback();
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String name) throws SQLException {
        return dao.findByName(name);
    }

    public void updateMoney(Account account) throws SQLException {
        dao.updateMoney(account);
    }
}
