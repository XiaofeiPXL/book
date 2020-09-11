package com.atguigu.utils.cookieUtils;

import javax.servlet.http.Cookie;

/**
 * @program: book
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/09/08 12:32
 */


public class cookieUtil {
    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name==null || cookies==null || cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
