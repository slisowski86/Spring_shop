package com.github.slisowski.Spring_shop.model;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> findAll();
    Optional<Category> findById(Integer id);
    Category save (Category entity);
 }
