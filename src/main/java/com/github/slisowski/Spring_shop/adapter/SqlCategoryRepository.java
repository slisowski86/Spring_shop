package com.github.slisowski.Spring_shop.adapter;

import com.github.slisowski.Spring_shop.model.Category;
import com.github.slisowski.Spring_shop.model.CategoryRepository;
import com.github.slisowski.Spring_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface SqlCategoryRepository extends CategoryRepository, JpaRepository<Category, Integer> {

    @Override
    @Query("from Category c join fetch c.products ")
    List<Category> findAll();

}
