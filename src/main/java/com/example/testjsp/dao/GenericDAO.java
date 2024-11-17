package com.example.testjsp.dao;

import com.example.testjsp.mapper.IRowMappers;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String query, IRowMappers<T> rowMapper, Object... prm);
    Integer insert(String query, Object... prm);
    void update(String query, Object... prm);
    void delete(String query, Object... prm);
    Integer count(String query, Object... prm);
}
