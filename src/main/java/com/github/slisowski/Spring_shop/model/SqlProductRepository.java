package com.github.slisowski.Spring_shop.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface SqlProductRepository extends ProductRepository, JpaRepository<Product, Integer> {




    List<Product> findProductByName(@Param("name") String name );



}
