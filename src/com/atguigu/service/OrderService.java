package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
*@program: book
*@description: TODO
*@author: Xiaofei Wang
*@created: 2020/09/10 13:54
*/


public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
