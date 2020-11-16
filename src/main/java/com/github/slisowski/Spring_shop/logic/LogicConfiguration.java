package com.github.slisowski.Spring_shop.logic;

import com.github.slisowski.Spring_shop.model.CategoryRepository;
import com.github.slisowski.Spring_shop.model.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {

    @Bean
    CategoryService categoryService(
            final CategoryRepository categoryRepository,
            final ProductRepository productRepository
            ){

        return new CategoryService(categoryRepository, productRepository);

    }
}
