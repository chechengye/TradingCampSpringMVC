package com.weichuang.service.impl;

import com.weichuang.mapper.ItemMapper;
import com.weichuang.pojo.Item;
import com.weichuang.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    /**
     * 获取商品列表的
     */
    @Override
    public List<Item> getItemList() {
        return itemMapper.getItemList();
    }

    @Override
    public Item getItemById(int id) {
        return itemMapper.getItemById(id);
    }

    @Override
    public int updateItem(Item item) {
        return itemMapper.updateItem(item);
    }
}
