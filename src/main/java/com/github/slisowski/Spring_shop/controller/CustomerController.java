package com.github.slisowski.Spring_shop.controller;


import com.github.slisowski.Spring_shop.model.Customer;
import com.github.slisowski.Spring_shop.model.CustomerRepository;
import com.github.slisowski.Spring_shop.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


    @RestController
    public class CustomerController {
        private static final Logger logger = LoggerFactory.getLogger(com.github.slisowski.Spring_shop.controller.CustomerController.class);
        private final CustomerRepository repository;

        public CustomerController(final CustomerRepository repository) {
            this.repository = repository;
        }




        @PostMapping("/customers")
        ResponseEntity<Customer> createCustomer (@RequestBody @Valid Customer createCustomer){
            Customer result = repository.save(createCustomer);
            return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
        }
        @GetMapping(value="/customers", params ={"!sort", "!page", "!size"})
        ResponseEntity<List<Customer>> readAllCustomers(){
            logger.warn("Showing all products");
            return ResponseEntity.ok(repository.findAll());
        }
}
