package com.github.slisowski.Spring_shop.adapter;

import com.github.slisowski.Spring_shop.model.Category;
import com.github.slisowski.Spring_shop.model.Customer;
import com.github.slisowski.Spring_shop.model.CustomerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlCustomerRepository extends CustomerRepository, JpaRepository<Customer, Integer> {

    @Override
    @Query("from Customer customer join fetch customer.orders ")
    List<Customer> findAll();
}
