package com.github.slisowski.Spring_shop.logic.servicerepo;

import java.util.List;

public interface JpaService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

    void update(T object);

    T saveOrUpdate(T object);
}
