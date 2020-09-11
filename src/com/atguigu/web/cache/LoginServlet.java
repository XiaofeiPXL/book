package com.atguigu.web.cache;

import com.atguigu.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: book
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/09/07 21:56
 */


public class LoginServlet extends BaseServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if("xiaolin".equals(username) && "222222".equals(password)){
            System.out.println("登录成功");
            Cookie cookie = new Cookie("username",username);
            cookie.setMaxAge(-1);
            resp.addCookie(cookie);
        }else{
            System.out.println("登陆失败");
        }
    }
}
