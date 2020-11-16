package com.github.slisowski.Spring_shop;

import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.*;


@Configuration
public class TestConfiguration {



    @Bean
    @Primary
    @Profile("!integration")
    DataSource e2eTestDataSource(){
        var result = new DriverManagerDataSource("jdbc:h2:mem:test", "sa", "");
        result.setDriverClassName("org.h2.Driver");
        return result;
    }


    @Bean
    @Primary
    @Profile("integration")
    ProductRepository testRepo() {

        return new ProductRepository() {

            private Map<Integer, Product> products = new HashMap<>();

            @Override
            public List<Product> findAll() {
                return new ArrayList<>(products.values());
            }

            @Override
            public Optional<Product> findById(Integer id) {
                return Optional.ofNullable(products.get(id));
            }

            @Override
            public boolean existsBySoldOutIsFalseAndCategory_Id(Integer ctegoryId) {
                return false;
            }

            @Override
            public boolean existsById(Integer id) {
                return products.containsKey(id);
            }

            @Override
            public Product save(Product entity) {
                return products.put(products.size() + 1, entity);
            }

            @Override
            public Page<Product> findAll(Pageable page) {
                return null;

            }

            @Override
            public List<Product> findProductByName(String name) {
                return null;
            }

            @Override
            public Product findBySoldOut(boolean soldOut) {
                return null;
            }


        };

    }
}




