package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: book
 * @description: 购物车对象
 * @author: Xiaofei Wang
 * @created: 2020/09/09 13:55
 */


public class Cart {
    // private Integer totalCount;
    // private BigDecimal totalPrice;
    /**
     * key是商品编号,value是商品信息
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for(Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    /**
     * 添加商品项
     *
     * @param cartItem 购物车商品项
     */
    public void addItem(CartItem cartItem) {
        //先查看购物车中是否已经添加过此商品,如果已经添加,则数量累加,总金额更新,如果没有添加过,直接放到集合中即可
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            //之前没有添加过此商品
            items.put(cartItem.getId(), cartItem);
        } else {
            //已经添加过的情况
            item.setCount(item.getCount() + 1);//数量累加
            //更新单个商品的价格
            item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getCount())));
        }
    }

    /**
     * 删除商品项
     *
     * @param id 商品id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品数量
     *
     * @param id    商品id
     * @param count 修改的数量
     */
    public void updateCount(Integer id, Integer count) {
         CartItem cartItem = items.get(id);
         if(cartItem!=null){
             cartItem.setCount(count);
             cartItem.setTotalPrice(cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getCount())));
         }
    }
}
