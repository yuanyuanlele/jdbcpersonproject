package com.person.utils;

import com.person.advanced.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Daoutils<T> {
    public int commonUpdate(String sql,Object...args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        connection=Dbutils.getconnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i< args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutils.closeall(connection,preparedStatement,null);
        }
        return 0;
    }

    public List<T> commonSelect(String sql, RowMapper<T> rowMapper,Object...args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<T> list=new ArrayList<>();
        connection=Dbutils.getconnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            if(args!=null){
                for(int i=0;i<args.length;i++){
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                T t=rowMapper.getRow(resultSet);
                list.add(t);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutils.closeall(connection,preparedStatement,resultSet);
        }
        return null;
    }
}
