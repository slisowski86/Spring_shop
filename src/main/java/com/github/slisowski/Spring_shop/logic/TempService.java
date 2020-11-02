package com.github.slisowski.Spring_shop.logic;

import com.github.slisowski.Spring_shop.model.CategoryRepository;
import com.github.slisowski.Spring_shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TempService {

    @Autowired
    List<String> temp(CategoryRepository repository){
        return repository.findAll().stream()
                .flatMap(category -> category.getProducts().stream())
                .map(Product::getDescription)
                .collect(Collectors.toList());

    }
}
