package com.atguigu.web.Ajax;

import com.atguigu.pojo.JsonDemo.Person;
import com.atguigu.web.BaseServlet;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: book
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/09/15 22:01
 */


public class AjaxServlet extends BaseServlet {
    public void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Ajax请求过来了");
        Person person = new Person(1, "花花");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    public void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("  jQueryAjax == 方法调用了");
        Person person = new Person(1, "花花");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    public void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("  jQueryGet  == 方法调用了");
        Person person = new Person(1, "花花");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    public void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("  jQueryPost   == 方法调用了");
        Person person = new Person(1, "花花");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }


    public void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("  jQueryGetJSON   == 方法调用了");
        Person person = new Person(1, "花花");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("  jQuerySerialize   == 方法调用了");

        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));

        Person person = new Person(1, "花花");
        // json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }
}
