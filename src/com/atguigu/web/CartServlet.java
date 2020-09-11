package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: book
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/09/09 16:09
 */


public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    /**
     * 加入购物车
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException Servlet异常
     * @throws IOException      IO流异常
     */
    public void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数,商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService的queryBookById(id),得到book对象
        Book book = bookService.queryBookById(id);
        //把图书信息转换为CartItem对象
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem()添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //判断购物车是否存在
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());
        //重定向回对应的请求界面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除商品项
     *
     * @param req  请求
     * @param resp 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO流异常
     */
    public void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            //删除购物车内对应的商品项
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req 请求
     * @param resp 响应
     * @throws ServletException Servlet异常
     * @throws IOException IO流异常
     */
    public void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 修改购物车的item数量
     * @param req 请求
     * @param resp 响应
     * @throws ServletException Servlet异常
     * @throws IOException IO流异常
     */
    public void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取商品数量
        int count = WebUtils.parseInt(req.getParameter("count"),1);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            //修改购物车对应的商品项数量
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
