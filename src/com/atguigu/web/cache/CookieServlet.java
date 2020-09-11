package com.atguigu.web.cache;

import com.atguigu.utils.cookieUtils.cookieUtil;
import com.atguigu.web.BaseServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: book
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/09/07 21:55
 */


public class CookieServlet extends BaseServlet {
    public void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = cookieUtil.findCookie("key1", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);//立刻删除
            resp.addCookie(cookie);
            resp.getWriter().write(cookie.getName() + "已经删除");
        }
    }

    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);//默认生存时间,浏览器关闭cookie删除
        resp.addCookie(cookie);
        resp.getWriter().write(cookie.getName() + "将在浏览器关闭后删除");
    }

    public void life3600(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);//设置cookie一小时后被删除
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的cookie,名字是" + cookie.getName());
    }

    public void getCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }
        if (cookieUtil.findCookie("key1", cookies) != null) {
            resp.getWriter().write("找到了相应的cookie");
        }
    }

    public void createCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //通知客户端
        resp.addCookie(cookie);
        resp.setContentType("UTF-8");
        resp.getWriter().write("Cookie创建成功");
    }

    public void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie cookie = cookieUtil.findCookie("key1", req.getCookies());
        if (cookie != null) {
            cookie.setValue("value2");
            resp.addCookie(cookie);
            resp.getWriter().write(cookie.getName() + "的value已经改变");
        }
    }
}
