package com.github.slisowski.Spring_shop.controller;

import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository repository;

    public ProductController(final ProductRepository repository) {
        this.repository = repository;
    }
    @GetMapping(value="/products", params ={"!sort", "!page", "!size"})
    ResponseEntity<List<Product>> readAllProducts(){
        logger.warn("Showing all products");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/products")
    ResponseEntity<List<Product>> readAllProducts(Pageable page){
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }
}
