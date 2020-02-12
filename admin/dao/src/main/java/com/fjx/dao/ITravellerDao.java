package com.fjx.dao;

import com.fjx.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("select * from traveller where id in(select travellerid from order_traveller where orderid=#{id})")
    public List<Traveller> findByOrderId(String id);
}
