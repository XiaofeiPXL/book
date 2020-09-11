package com.atguigu.test.dao;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: book
 * @description:
 * @author: Xiaofei Wang
 * @created: 2020/09/10 13:23
 */


class OrderDaoTest {

    @Test
    void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0, 4));

    }
}