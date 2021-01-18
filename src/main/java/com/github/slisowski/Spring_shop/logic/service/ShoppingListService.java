package com.github.slisowski.Spring_shop.logic.service;

import com.github.slisowski.Spring_shop.logic.servicerepo.ShoppingListRepoService;
import com.github.slisowski.Spring_shop.model.ShoppingList;
import com.github.slisowski.Spring_shop.model.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingListService implements ShoppingListRepoService {

    final ShoppingListRepository repository;

    ShoppingListService(final ShoppingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<ShoppingList> findAll() {
        Set<ShoppingList> shoppingLists = new HashSet<>();
        repository.findAll().forEach(shoppingLists::add);
        return shoppingLists;

    }

    @Override
    public ShoppingList findById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ShoppingList save(final ShoppingList shoppingList) {
        return repository.save(shoppingList);
    }

    @Override
    public void delete(final ShoppingList shoppingList) {
        repository.delete(shoppingList);

    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);

    }
}
