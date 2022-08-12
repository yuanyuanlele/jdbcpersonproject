package com.person.dao.impl;

import com.person.advanced.PersonRowMapperImpl;
import com.person.dao.PersonDao;
import com.person.enity.Person;
import com.person.utils.Daoutils;
import com.person.utils.Dateutils;
import com.person.utils.Dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    private Daoutils<Person> daoutils=new Daoutils();
    @Override
    public int insert(Person person) {
        String sql="insert into person(name,age,bornDate,email,address) values (?,?,?,?,?)";
        Object[]args={person.getName(),person.getAge(),person.getBornDate(),person.getEmail(),person.getAddress()};
        return daoutils.commonUpdate(sql,args);
    }

    @Override
    public int delete(int id) {
        String sql="delete from person where id=?";
        return daoutils.commonUpdate(sql,id);
    }

    @Override
    public int update(Person person) {
        String sql="update person set name=?,age=?,bornDate=?,emali=?,address=? where id=?";
        Object[]args={person.getName(),person.getAge(),person.getBornDate(),person.getEmail(),person.getAddress(),person.getId()};
        return daoutils.commonUpdate(sql,args);
    }

    @Override
    public Person select(int id) {
        String sql="select * from person where id=?";
        List<Person> list=daoutils.commonSelect(sql,new PersonRowMapperImpl(),id);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Person> selectall() {
        String sql="select *from person";
        List<Person> list=new ArrayList<>();
        list=daoutils.commonSelect(sql,new PersonRowMapperImpl(),null);
        return null;
    }
}
