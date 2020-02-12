package com.fjx.service.impl;

import com.fjx.dao.IProductDao;
import com.fjx.domain.Product;
import com.fjx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService{


    @Autowired
    private IProductDao dao;

    @Override
    public List<Product> findAll() {
        List<Product> all = null;
        try {
            all = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public void save(Product product) {
        try {
            dao.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
