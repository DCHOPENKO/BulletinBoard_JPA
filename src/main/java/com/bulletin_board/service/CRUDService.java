package com.bulletin_board.service;

public interface CRUDService<T> {

    void save(T t);

    void update(T t);

    void deleteById(int id);

    T getById(int id);

}
