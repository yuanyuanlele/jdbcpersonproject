package com.person.view;

import com.person.dao.impl.PersonDaoImpl;
import com.person.enity.Person;
import com.person.utils.Daoutils;

public class TestPerson {
    public static void main(String[] args) {
        PersonDaoImpl personDao=new PersonDaoImpl();
        Person person=personDao.select(3);
        System.out.println(person);
    }
}
