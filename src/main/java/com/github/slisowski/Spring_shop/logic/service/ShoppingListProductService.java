package com.github.slisowski.Spring_shop.logic.service;

import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ShoppingListProduct;
import com.github.slisowski.Spring_shop.model.ShoppingListProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ShoppingListProductService  {

    private final ShoppingListProductRepository shoppingListProductRepository;

    public ShoppingListProductService(final ShoppingListProductRepository shoppingListProductRepository) {
        this.shoppingListProductRepository = shoppingListProductRepository;
    }


    public List<Product> findProducts(Long shoppingListId){

        List<ShoppingListProduct> result;
        result = shoppingListProductRepository.findShoppingListProductsByShoppingList_Id(shoppingListId);
        return  result.stream().map(ShoppingListProduct::getProduct).collect(Collectors.toList());


    }
}
