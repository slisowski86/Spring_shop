package com.github.slisowski.Spring_shop.logic;

import com.github.slisowski.Spring_shop.model.*;
import com.github.slisowski.Spring_shop.model.projection.CategoryReadModel;
import com.github.slisowski.Spring_shop.model.projection.CategoryWriteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class CategoryService {

    private CategoryRepository repository;
    private ProductRepository productRepository;


    public CategoryService(CategoryRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }
    public CategoryReadModel createCategory (CategoryWriteModel source){
        Category result = repository.save(source.toCategory());
        return new CategoryReadModel(result);
    }

    public List<CategoryReadModel> readAll(){
        return repository.findAll().stream()
                .map(CategoryReadModel::new)
                .collect(Collectors.toList());
    }


}
