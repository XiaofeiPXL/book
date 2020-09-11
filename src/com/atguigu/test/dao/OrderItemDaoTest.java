package com.atguigu.test.dao;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: book
 * @description:
 * @author: Xiaofei Wang
 * @created: 2020/09/10 13:23
 */


class OrderItemDaoTest {

    @Test
    void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到放弃", 1,new BigDecimal(80.00),new BigDecimal(100),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"javaScript从入门到精通", 2,new BigDecimal(9.90),new BigDecimal(19.80),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"C++编程思想 ", 1,new BigDecimal(45.50),new BigDecimal(45.50),"1234567890"));
    }
}