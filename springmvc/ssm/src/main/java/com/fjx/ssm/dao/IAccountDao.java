package com.fjx.ssm.dao;

import com.fjx.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAccountDao {

    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account(username,money)values(#{username},#{money})")
    public void save(Account account);

}
