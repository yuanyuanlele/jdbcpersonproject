package com.person.dao;

import com.person.enity.Person;

import java.util.List;

public interface PersonDao {
    public int insert(Person person);

    public int delete(int id);

    public int update(Person person);

    public Person select(int id);

    public List<Person> selectall();
}
