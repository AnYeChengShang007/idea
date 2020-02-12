package com.fjx.service.impl;

import com.fjx.dao.ItemsDao;
import com.fjx.domain.Item;
import com.fjx.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsDao dao;

    public Item findById(Integer id) {
        return dao.findById(id);
    }
}
