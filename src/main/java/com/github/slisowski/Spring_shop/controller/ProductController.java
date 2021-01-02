package com.github.slisowski.Spring_shop.controller;

import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
;
import com.github.slisowski.Spring_shop.model.projection.ListProductReadModel;
import com.github.slisowski.Spring_shop.model.projection.ListProductWriteModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
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

    @ResponseBody
    @PostMapping()
    ResponseEntity<Product> createProduct(@RequestBody @Valid Product toCreate){
       Product result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }
    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Product>> readAllProducts(){
        logger.warn("Showing all products");

        return ResponseEntity.ok(repository.findAll());
     }





    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
            ResponseEntity<Product> readProduct(@PathVariable int id){

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());


    }

    @GetMapping("/search/bought")
    ResponseEntity<List<Product>> readBoughtProducts(@RequestParam(defaultValue = "true") boolean state){
        return ResponseEntity.ok(
                repository.findProductByBought(state)
        );

    }


    @PutMapping("/{id}")
    ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody @Valid Product toUpdate){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(product-> {
                    product.updateFrom(toUpdate);
                    repository.save(product);
                });
        return ResponseEntity.noContent().build();



    }


    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(product -> product.setBought(!product.isBought()));
        return ResponseEntity.noContent().build();
    }




}
