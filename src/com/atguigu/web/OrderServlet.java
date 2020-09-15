package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @program: book
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/09/10 14:41
 */


public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException Servlet异常
     * @throws IOException      IO流的异常
     */
    public void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //在session中获取用户对象
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        String orderId = orderService.createOrder(cart, loginUser.getId());
        //将生成的订单号保存到request域中
        req.getSession().setAttribute("orderId", orderId);
        System.out.println(req.getContextPath());
        //请求重定向
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
