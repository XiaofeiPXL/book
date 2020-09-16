package com.atguigu.pojo.JsonDemo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: book
 * @description: JSON对象和字符串的相互转换
 * @author: Xiaofei Wang
 * @created: 2020/09/15 19:48
 */


public class JsonTest {
    //1.javaBean和JSON的转换
    @Test
    public void test1() {
        Person person = new Person(1, "花花");
        //创建Gson对象
        Gson gson = new Gson();
        //javaBean对象转换成为JSON对象
        String personToJson = gson.toJson(person);
        System.out.println(personToJson);
        //第一个参数是对应的JSON字符串,第二个参数是字符串对应的对象类型
        Person trPerson = gson.fromJson(personToJson,Person.class);
        System.out.println(trPerson);
    }
    //2.MAP和JSON的转换
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(1,"花花"));
        personMap.put(2,new Person(2,"点点"));
        Gson gson = new Gson();
        String personMapToJson = gson.toJson(personMap);
        //使用匿名内部类,优化代码结构
        Map<Integer,Person> personMap1 = gson.fromJson(personMapToJson,new TypeToken<HashMap<Integer,Person>>(){}.getType());
        Person mapPerson = personMap1.get(1);
        System.out.println(mapPerson);
    }

    //3.List和JSON的转换
    @Test
    public void test2(){
        List<Person> personList = new LinkedList<>();
        personList.add(new Person(1,"花花"));
        personList.add(new Person(2,"点点"));
        Gson gson = new Gson();
        String personListToJson = gson.toJson(personList);
        System.out.println(personListToJson);
        //调用getType()!!!
        List<Person> list = gson.fromJson(personListToJson,new PersonListType().getType());
        System.out.println(list.get(0));
    }
}