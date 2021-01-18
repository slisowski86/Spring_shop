package com.github.slisowski.Spring_shop.controller;


import com.github.slisowski.Spring_shop.logic.servicerepo.ShoppingListRepoService;
import com.github.slisowski.Spring_shop.logic.servicerepo.ProductRepoService;
import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
import com.github.slisowski.Spring_shop.model.ShoppingList;

import com.github.slisowski.Spring_shop.model.ShoppingListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/lists")
class ShoppingListController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingListController.class);

    private final ShoppingListRepoService service;
    private final ProductRepository repository;
    private final ShoppingListRepository shoppingListRepository;
    private final ProductRepoService productService;


    ShoppingListController(final ShoppingListRepoService service, final ProductRepository repository, final ShoppingListRepository shoppingListRepository, final ProductRepoService productService) {
        this.service = service;
        this.repository = repository;
        this.shoppingListRepository = shoppingListRepository;
        this.productService = productService;
    }

    /*private static final Logger logger = LoggerFactory.getLogger(ShoppingListController.class);

    private final ShoppingListRepository repository;
    private final ShoppingListService service;

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

        Set<ShoppingList> lists = service.findAll();
        model.addAttribute("updatedLists",  lists);
        return "shoppingLists/lists";
    }
    @PostMapping(value ="/new" ,produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addList(Model model, @Valid ShoppingList currentList ,
                   BindingResult bindingResult){


            if (bindingResult.hasErrors()) {
                return "shoppingLists/lists";
            }
         ShoppingList savedList= service.save(currentList);

        return "redirect:/lists/addProducts/" + savedList.getId();


    }




    @GetMapping(value="/new", produces = MediaType.TEXT_HTML_VALUE)
    String showCreateGroupForm(Model model)
    {


        model.addAttribute("list", ShoppingList.builder().build() );

        return "shoppingLists/new";
    }

    @GetMapping("/addProducts/{shoppingListId}")
    public ModelAndView showShoppingList(@PathVariable Long shoppingListId) {
        List<Product> products=new ArrayList<>();
        Set<Product> productsToAdd = productService.findAll();
        ModelAndView mav = new ModelAndView("shoppingLists/addProducts");
        mav.addObject("newList", service.findById(shoppingListId));
        mav.addObject("products", products);
        mav.addObject("productsToAdd", productsToAdd);
        return mav;
    }












    @GetMapping (value = "/showProducts")
    String  showProducts(Model model, @RequestParam(value = "shoppingList_ID", required = false) Long id){

        ShoppingList currentList = service.findById(id);
        List<Product> products = productService.findProductsByShoppingLists_Id(id);
        model.addAttribute("currentList", currentList);
        model.addAttribute("products", products);
        return "showProducts";


    }




















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



