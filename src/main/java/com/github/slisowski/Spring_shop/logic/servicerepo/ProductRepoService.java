package com.github.slisowski.Spring_shop.logic.servicerepo;

import com.github.slisowski.Spring_shop.logic.servicerepo.CrudService;
import com.github.slisowski.Spring_shop.model.Product;

import java.util.List;


public interface ProductRepoService extends CrudService<Product, Long> {

    List<Product> findProductsByShoppingLists_Id(Long listId);
}


