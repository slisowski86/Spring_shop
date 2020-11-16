package com.github.slisowski.Spring_shop.controller;

import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    ProductRepository repo;
    @Test
    void httpGet_returnsAllProducts(){
        //given
        repo.save(new Product("Lego", "Lego City", 121.99));
        repo.save(new Product("Duplo", "Lego Star Wars", 149.99));

        //when
        Product []result = restTemplate.getForObject("http://localhost:"+port+"/products", Product[].class);
        //

        assertThat(result).hasSize(2);
    }
}