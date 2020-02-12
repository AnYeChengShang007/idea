package com.fjx.dao;

import com.fjx.domain.Member;
import com.fjx.domain.Orders;
import com.fjx.domain.Product;
import com.fjx.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface IOrderDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", one = @One(
                    select = "com.fjx.dao.IProductDao.findById"))
    })
    public List<Orders> findAll();

    /*private String id;
    private String orderStatusStr;*/
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productid",javaType = Product.class,one=@One(select="com.fjx.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberid",javaType = Member.class,one=@One(select="com.fjx.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.fjx.dao.ITravellerDao.findByOrderId"))
    })
    Orders findById(String id);
}
