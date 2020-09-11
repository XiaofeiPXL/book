package com.atguigu.test.entity;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


/**
 * @program: book
 * @description:
 * @author: Xiaofei Wang
 * @created: 2020/09/09 14:56
 */


class CartTest {

    Cart cart = new Cart();

    @Test
    void addItem() {
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    void clear() {
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    void updateCount() {
        cart.addItem(new CartItem(1,"Java从入门到放弃",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.updateCount(1,10);
        System.out.println(cart);
    }
}