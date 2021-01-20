package com.github.slisowski.Spring_shop.logic.servicerepo;

import com.github.slisowski.Spring_shop.model.Product;


public interface ProductRepoService extends JpaService<Product, Long> {

    Product findByName(String name);
}


