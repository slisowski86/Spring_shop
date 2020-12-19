package com.github.slisowski.Spring_shop.model.projection;

import com.github.slisowski.Spring_shop.model.ShoppingList;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListWriteModel {


    @NotBlank(message="Nazwa listy nie może być pusta ListWriter")
    private String name;
    @Valid
    private List<ListProductWriteModel> products = new ArrayList<>();
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateCreated;


    public ListWriteModel(){
        products.add(new ListProductWriteModel());
    }
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<ListProductWriteModel> getProducts() {
        return products;
    }

    public void setProducts(final List<ListProductWriteModel> products) {
        this.products = products;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ShoppingList toShoppingList(){
        var result = new ShoppingList();
        result.setName(name);
        result.setProducts(products.stream()
                            .map(source->source.toProduct(result))
                                .collect(Collectors.toList()));
        result.setDateCreate(dateCreated);
        return result;


    }
}
