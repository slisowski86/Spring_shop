package com.github.slisowski.Spring_shop.controller;


import com.github.slisowski.Spring_shop.logic.ProductListService;
import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ShoppingList;
import com.github.slisowski.Spring_shop.model.projection.ListProductWriteModel;
import com.github.slisowski.Spring_shop.model.projection.ListReadModel;
import com.github.slisowski.Spring_shop.model.projection.ListWriteModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/lists")
class ShoppingListController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingListController.class);

    private final ProductListService service;

    ShoppingListController(final ProductListService service) {
        this.service = service;
    }

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


        model.addAttribute("list", new ListWriteModel() );
        return "lists";
    }


    @PostMapping(params = "addProduct")
    String addListProduct(@ModelAttribute("list") ListWriteModel current){
        logger.info("Metoda addListProduct");
        current.getProducts().add(new ListProductWriteModel());
        return "lists";

    }

    @PostMapping
    String addList(
            @ModelAttribute ("list") @Valid ListWriteModel current,
            BindingResult bindingResult,
            Model model){

        if(bindingResult.hasErrors()){
            return "lists";
        }



        service.save(current);
        model.addAttribute("list", new ListWriteModel());
        model.addAttribute("lists", getLists());
        model.addAttribute("message", "Dodano listę zakupów");
        return "lists";
    }

    @ModelAttribute("lists")
    List<ShoppingList> getLists(){

        return service.readAll();
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