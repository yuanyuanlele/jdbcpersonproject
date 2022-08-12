package com.person.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Dbutils {
    private static final Properties PROPERTIES=new Properties();
    private static final ThreadLocal<Connection> THREAD_LOCAL=new ThreadLocal<>();
    static {
        InputStream is=Dbutils.class.getResourceAsStream("/database.properties");
        try {
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection(){
        Connection connection=THREAD_LOCAL.get();
        if(connection==null){
            try {
                connection= DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password"));
                THREAD_LOCAL.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void begin(){
        Connection connection=null;
        connection=getconnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(){
        Connection connection=null;
        connection=getconnection();
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeall(connection,null,null);
        }
    }

    public static void rollback(){
        Connection connection=null;
        connection=getconnection();
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeall(connection,null,null);
        }
    }

    public static void closeall(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
