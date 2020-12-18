package com.github.slisowski.Spring_shop.logic;


import com.github.slisowski.Spring_shop.model.ProductRepository;
import com.github.slisowski.Spring_shop.model.ShoppingList;
import com.github.slisowski.Spring_shop.model.ShoppingListRepository;
import com.github.slisowski.Spring_shop.model.projection.ListProductReadModel;
import com.github.slisowski.Spring_shop.model.projection.ListReadModel;
import com.github.slisowski.Spring_shop.model.projection.ListWriteModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductListService {

    private final ShoppingListRepository repository;

    private ProductRepository productRepository;

    ProductListService(final ShoppingListRepository repository, final ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    public ListReadModel createList(final ListWriteModel source) {
        ShoppingList result = repository.save(source.toShoppingList());
        return new ListReadModel(result);

    }

    public List<ListReadModel> readAll() {
        return repository.findAll().stream()
                .map(ListReadModel::new)
                .collect(Collectors.toList());
    }



    public void toggleList(int shoppingListId) {

        if (productRepository.existsByBoughtIsFalseAndShoppingLists_Id(shoppingListId)) {
            throw new IllegalStateException("Twoja Lista zakupów posiada niekupione produkty");
        }
        ShoppingList result = repository.findById(shoppingListId).orElseThrow(() -> new IllegalArgumentException("Lista zakupów z podanym id nie sitnieje"));
        result.setCompleted(!result.isCompleted());
        repository.save(result);

    }
}
