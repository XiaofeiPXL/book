package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection(){

        Connection conn = threadLocal.get();

        if(conn==null){
            try{
                conn = dataSource.getConnection(); //从数据库连接池获取连接
                threadLocal.set(conn);//保存到ThreadLocal对象中,供后面的jdbc操作使用
                conn.setAutoCommit(false);//设置为手动管理事务
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务,并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = threadLocal.get();
        //如果不等于null,说明之前操作过数据库,使用过连接
        if(connection!=null){
            try{
                connection.commit();//提交事务
            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    connection.close();//关闭连接,释放资源
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        //Tomcat底层使用了线程池技术
        threadLocal.remove();
    }


    /**
     * 回滚事务,并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = threadLocal.get();
        //如果不等于null,说明之前操作过数据库,使用过连接
        if(connection!=null){
            try{
                connection.rollback();//提交事务
            }catch(SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    connection.close();//关闭连接,释放资源
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        //Tomcat底层使用了线程池技术
        threadLocal.remove();
    }

}