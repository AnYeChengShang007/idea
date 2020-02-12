package com.fjx.service.impl;

import com.fjx.dao.IOrderDao;
import com.fjx.domain.Orders;
import com.fjx.domain.Product;
import com.fjx.service.IOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao dao;

    @Override
    public List<Orders> findAll() {
        PageHelper.startPage(1,5);
        return dao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return dao.findById(id);
    }

    @Override
    public List<Orders> findAll(int pageNum, int size) {
        PageHelper.startPage(pageNum,size);
        return dao.findAll();
    }
}
