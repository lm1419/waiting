package com.lm.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lm
 * @version V1.0
 * @Package com.lm.utils
 * @date 2019/11/4 16:08
 */
public class JdbcUtils {
    private static  DataSource ds;
    static{
        Properties prop=new Properties();
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            prop.load(is);
            ds= DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeAll(ResultSet rs, PreparedStatement ps,Connection conn){
        try{
        if (rs!=null){
            rs.close();
        }
        if (ps!=null){
            ps.close();
        }
        if (conn!=null){
            conn.close();
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
