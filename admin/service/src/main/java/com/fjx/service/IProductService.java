package com.fjx.service;

import com.fjx.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findAll();

    public void save(Product product);
}
