package com.person.view;

import com.person.dao.impl.PersonDaoImpl2;
import com.person.enity.Person;
import com.person.utils.Dateutils;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        //Person person=new Person(5,"刷大",35, Dateutils.strtoUtil("2010-06-07"),"asdkh@qq.com","啊是对国会");
        PersonDaoImpl2 personDaoImpl2=new PersonDaoImpl2();
        List<Person> list =personDaoImpl2.selectall();
        for(Person person:list){
            System.out.println(person);
        }
    }

}
