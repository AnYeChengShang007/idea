package com.fjx.transaction.dao;

import com.fjx.transaction.demo.Account;
import com.fjx.transaction.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

@Repository("dao")
public class AccountDao implements IAccountDao {

    @Resource(name="util")
    private DataSourceUtil util;

    @Resource(name="runner")
    private QueryRunner runner;

    public Account findByName(String name) throws SQLException {
        return runner.query(util.getConnection(),"select * from account where name = ?",new BeanHandler<Account>(Account.class),name);
    }

    public void updateMoney(Account account) throws SQLException {
        runner.update(util.getConnection(),"update account set money=? where id=?",account.getMoney(),account.getId());
    }
}
