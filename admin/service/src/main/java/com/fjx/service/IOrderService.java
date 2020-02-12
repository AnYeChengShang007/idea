package com.fjx.service;

import com.fjx.domain.Orders;
import com.fjx.domain.Product;

import java.util.List;

public interface IOrderService {
    public List<Orders> findAll();

    public Orders findById(String id);

    public List<Orders> findAll(int pageNum, int size);

}
