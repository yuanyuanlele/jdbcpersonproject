package com.person.advanced;

import com.person.enity.Person;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapperImpl implements RowMapper<Person>{
    @Override
    public Person getRow(ResultSet resultSet) {
        Person person=null;
        try {
                person=new Person();
                int person_id=resultSet.getInt("id");
                String person_name=resultSet.getString("name");
                int person_age=resultSet.getInt("age");
                Date person_bornDate=resultSet.getDate("bornDate");
                String person_email=resultSet.getString("email");
                String person_address=resultSet.getString("address");
                person.setId(person_id);
                person.setName(person_name);
                person.setAge(person_age);
                person.setBornDate(person_bornDate);
                person.setEmail(person_email);
                person.setAddress(person_address);
                return person;
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
