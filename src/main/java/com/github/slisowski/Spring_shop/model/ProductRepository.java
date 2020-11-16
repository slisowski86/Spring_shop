package com.github.slisowski.Spring_shop.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.net.ContentHandler;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();
    Optional<Product> findById(Integer id);
    boolean existsBySoldOutIsFalseAndCategory_Id(Integer categoryId);
    boolean existsById(Integer id);
    Product save (Product entity);

    Page<Product> findAll(Pageable page);
    List<Product> findProductByName(@Param("name") String name );
    Product findBySoldOut(boolean soldOut);


}
