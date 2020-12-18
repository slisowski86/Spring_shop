package com.github.slisowski.Spring_shop.controller;


import com.github.slisowski.Spring_shop.logic.ProductListService;
import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ShoppingList;
import com.github.slisowski.Spring_shop.model.ShoppingListRepository;
import com.github.slisowski.Spring_shop.model.projection.ListReadModel;
import com.github.slisowski.Spring_shop.model.projection.ListWriteModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/lists")
class ShoppingListController {

    /*private static final Logger logger = LoggerFactory.getLogger(ShoppingListController.class);

    private final ShoppingListRepository repository;
    private final ProductListService service;

    ShoppingListController(final ShoppingListRepository repository, final ProductListService service) {

        this.repository = repository;

        this.service = service;
    }*/

    /*@PostMapping

    ResponseEntity<ListReadModel> createShoppingList(@RequestBody ListWriteModel toCreate){
        ListReadModel result = service.createList(toCreate);
       return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }*/


    @GetMapping
    String showLists(Model model){
        var listToEdit = new ListWriteModel();
        listToEdit.setName("Testowa lista");
        model.addAttribute("list", listToEdit );
        return "lists";
    }

   /*@GetMapping(params={"!page, !size,!sort"})
    ResponseEntity<List<ListReadModel>> readAllLists(){

        return ResponseEntity.ok(service.readAll());
   }

   @GetMapping("/{id}")
   ResponseEntity<List<ShoppingList>> readAllProductsFromList(@PathVariable int id){
        return ResponseEntity.ok(repository.findAll());
   }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<?> toggleList(@PathVariable int id) {
        service.toggleList(id);
        return ResponseEntity.noContent().build();

    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<?> handleIllegalArgument(IllegalArgumentException e){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<String> handleIllegalState(IllegalStateException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }*/


}
