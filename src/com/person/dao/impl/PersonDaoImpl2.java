package com.person.dao.impl;

import com.person.dao.PersonDao;
import com.person.enity.Person;
import com.person.utils.Dateutils;
import com.person.utils.Dbutils2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PersonDaoImpl2 implements PersonDao {
    private QueryRunner queryRunner=new QueryRunner(Dbutils2.getDataSource());
    @Override
    public int insert(Person person) {
        Object[] params={person.getId(),person.getName(),person.getAge(), Dateutils.utiltoSql(person.getBornDate()),person.getEmail(),person.getAddress()};
        int result= 0;
        try {
            result = queryRunner.update("insert into person(id,name,age,bornDate,email,address) values(?,?,?,?,?,?)",params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int id) {
        int result = 0;
        try {
            result = queryRunner.update("delete from person where id=?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Person person) {
        Object[] params = {person.getName(),person.getAge(),Dateutils.utiltoSql(person.getBornDate()), person.getEmail(), person.getAddress(), person.getId()};
        int result = 0;
        try {
            result = queryRunner.update("update person set name=?,age=?,bornDate=?,email=?,address=? where id=?", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Person select(int id) {
        try {
            Person person=queryRunner.query("select * from person where id=?",new BeanHandler<Person>(Person.class),id);
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> selectall() {
        List<Person> list= null;
        try {
            list = queryRunner.query("select * from person",new BeanListHandler<Person>(Person.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
