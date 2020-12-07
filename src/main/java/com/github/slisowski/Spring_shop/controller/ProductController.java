package com.github.slisowski.Spring_shop.controller;

import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository repository;


    public ProductController(final ProductRepository repository) {
        this.repository = repository;

    }


    @PostMapping
    ResponseEntity<Product> createProduct(@RequestBody @Valid Product toCreate){
        Product result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }
    @GetMapping(params ={"!page", "!size", "!sort"})
    ResponseEntity<List<Product>> readAllProducts(){
        logger.warn("Showing all products");

        return ResponseEntity.ok(repository.findAll());
     }



     @GetMapping
    ResponseEntity<List<Product>> readAllProducts(Pageable page){
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }



    @GetMapping("/{id}")
            ResponseEntity<Product> readProduct(@PathVariable int id){

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }



    @PutMapping("/{id}")
    ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody @Valid Product toUpdate){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(product -> {product.updateFrom(toUpdate);
                                        repository.save(toUpdate);});
        return ResponseEntity.noContent().build();
    }




}