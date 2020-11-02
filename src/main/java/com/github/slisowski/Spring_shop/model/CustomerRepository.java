package com.github.slisowski.Spring_shop.model;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    Customer save (Customer entity);
}
