package com.github.slisowski.Spring_shop.logic.service;

import com.github.slisowski.Spring_shop.model.ShoppingListProduct;
import com.github.slisowski.Spring_shop.model.ShoppingListProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingListProductService {

    private final ShoppingListProductRepository shoppingListProductRepository;

    public ShoppingListProductService(final ShoppingListProductRepository shoppingListProductRepository) {
        this.shoppingListProductRepository = shoppingListProductRepository;
    }

    public ShoppingListProduct create(ShoppingListProduct shoppingListProduct){
        return this.shoppingListProductRepository.save(shoppingListProduct);
    }
}
