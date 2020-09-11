package com.atguigu.test.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


/**
 * @program: book
 * @description:
 * @author: Xiaofei Wang
 * @created: 2020/09/10 14:24
 */


class OrderServiceTest {

    @Test
    void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(80.00),new BigDecimal(80.00)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(80.00),new BigDecimal(80.00)));
        cart.addItem(new CartItem(2,"数据结构与算法",1,new BigDecimal(78.50),new BigDecimal(78.50)));

        OrderService orderService = new OrderServiceImpl();
        System.out.println("Order#:["+orderService.createOrder(cart,4)+"]");
    }
}