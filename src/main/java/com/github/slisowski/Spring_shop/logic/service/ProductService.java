package com.github.slisowski.Spring_shop.logic.service;

import com.github.slisowski.Spring_shop.logic.servicerepo.ProductRepoService;
import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService implements ProductRepoService {

    final ProductRepository repository;

    public ProductService(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Product> findAll() {
        Set<Product> products = new HashSet<>();
        repository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product findById(final Long id) {
        return repository.findById(id).orElse(null);
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
    public List<Product> findProductsByShoppingLists_Id(final Long listId) {
        return repository.findProductsByShoppingLists_Id(listId);
    }
}
