package com.person.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Dateutils {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd");

    public static java.util.Date strtoUtil(String str){
        try {
            return SIMPLE_DATE_FORMAT.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static java.sql.Date utiltoSql(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }

    public static String utiltoStr(java.util.Date date){
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
