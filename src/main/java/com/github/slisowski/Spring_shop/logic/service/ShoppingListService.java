package com.github.slisowski.Spring_shop.logic.service;

import com.github.slisowski.Spring_shop.logic.servicerepo.ShoppingListRepoService;
import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ShoppingList;
import com.github.slisowski.Spring_shop.model.ShoppingListProduct;
import com.github.slisowski.Spring_shop.model.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class ShoppingListService implements ShoppingListRepoService {

    final ShoppingListRepository repository;

    ShoppingListService(final ShoppingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ShoppingList> findAll() {
        List<ShoppingList> shoppingLists = new ArrayList<>();
        repository.findAll().forEach(shoppingLists::add);
        return shoppingLists;

    }

    @Override
    public ShoppingList findById(final Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ShoppingList save(final ShoppingList shoppingList) {
        shoppingList.setDateCreate(LocalDateTime.now());
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
    @Override

    public void addProduct(Product product, ShoppingList shoppingList){

        ShoppingListProduct shoppingListProduct = new ShoppingListProduct(shoppingList,product);
        shoppingListProduct.setProduct(product);
        shoppingListProduct.setShoppingList(shoppingList);
        shoppingList.getShoppingListProducts().add(shoppingListProduct);
        product.getShoppingListProducts().add(shoppingListProduct);
    }





    @Override
    public void update(final ShoppingList shoppingList) {
        this.repository.save(shoppingList);

    }

    @Override
    public ShoppingList saveOrUpdate(final ShoppingList object) {
        return repository.save(object);
    }


}
