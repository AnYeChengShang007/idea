package com.fjx.dao;

import com.fjx.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IProductDao {

    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product (id,productNum,productName,cityName,DepartureTime,productDesc,productPrice,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productDesc},#{productPrice},#{productStatus})")
    void save(Product product) throws Exception;

    @Select("select * from product where id= #{id}")
    Product findById(String id);
}
