package com.github.slisowski.Spring_shop.logic.service;

import com.github.slisowski.Spring_shop.logic.servicerepo.ProductRepoService;
import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService implements ProductRepoService {

    final ProductRepository repository;

    public ProductService(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product findById(final Long id) {
        return repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(final Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(final Product product) {
        repository.delete(product);

    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);

    }

    @Override
    public void update(final Product product) {

    }


    @Override
    public Product findByName(final String name) {
        return repository.findByName(name);
    }
}
