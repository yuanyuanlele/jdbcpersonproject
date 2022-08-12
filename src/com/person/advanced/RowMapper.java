package com.person.advanced;

import java.sql.ResultSet;

public interface RowMapper<T> {
    public T getRow(ResultSet resultSet);
}
