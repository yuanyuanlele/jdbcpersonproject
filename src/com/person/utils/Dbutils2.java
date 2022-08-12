package com.person.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Dbutils2 {
    private static DruidDataSource ds;

    static {
        Properties properties = new Properties();
        InputStream is = Dbutils2.class.getResourceAsStream("/database.properties");
        try {
            properties.load(is);
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static Connection getconnection(){
            try {
                return ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static DataSource getDataSource(){
        return ds;
        }
}

