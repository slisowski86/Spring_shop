package com.github.slisowski.Spring_shop.controller;


import com.github.slisowski.Spring_shop.logic.service.ShoppingListProductService;
import com.github.slisowski.Spring_shop.logic.servicerepo.ProductRepoService;
import com.github.slisowski.Spring_shop.logic.servicerepo.ShoppingListRepoService;
import com.github.slisowski.Spring_shop.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lists")
class ShoppingListController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingListController.class);

    private final ShoppingListRepoService service;
    private final ProductRepository repository;
    private final ShoppingListRepository shoppingListRepository;
    private final ProductRepoService productService;
    private final ShoppingListProductService shoppingListProductService;


    ShoppingListController(final ShoppingListRepoService service, final ProductRepository repository, final ShoppingListRepository shoppingListRepository, final ProductRepoService productService, final ShoppingListProductService shoppingListProductService) {
        this.service = service;
        this.repository = repository;
        this.shoppingListRepository = shoppingListRepository;
        this.productService = productService;
        this.shoppingListProductService = shoppingListProductService;
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


        model.addAttribute("updatedLists",  getShoppingLists());
        return "shoppingLists/lists";
    }

    @GetMapping(value="/new", produces = MediaType.TEXT_HTML_VALUE)
    String showCreateGroupForm(Model model)
    {

        model.addAttribute("products", productService.findAll());
        model.addAttribute("list", ShoppingList.builder().build() );

        return "shoppingLists/new";
    }
    @PostMapping(value ="/new" ,produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addList(@ModelAttribute("list") ShoppingList currentList,
                   Model model, @RequestParam(value="id") Long id){


            /*if (bindingResult.hasErrors()) {
                return "shoppingLists/lists";
            }else {*/

                List<ShoppingListProduct> shoppingListProducts = new ArrayList<>();
                service.save(currentList);

                model.addAttribute("id", id);
                Product product = productService.findById(id);

                logger.info(product.getName());
                shoppingListProducts.add(shoppingListProductService.create(new ShoppingListProduct(product, currentList)));
                currentList.setShoppingListProducts(shoppingListProducts);
                service.update(currentList);

                return "redirect:/lists/addProducts/" + currentList.getId();



    }

    @PostMapping(params="addProductToList")
    String addProducts(Model model,  @ModelAttribute("list") @Valid ShoppingList shoppingList,  @Valid Product product){


        logger.info("Dodano produkt");
        shoppingList.getShoppingListProducts().add(new ShoppingListProduct(product, shoppingList));
        return "shoppingLists/addProducts";
    }





    @GetMapping("/addProducts/{shoppingListId}")
    public ModelAndView showShoppingList(@PathVariable Long shoppingListId) {

        ModelAndView mav = new ModelAndView("shoppingLists/addProducts");
        mav.addObject("newList", service.findById(shoppingListId));

        return mav;
    }


    @ModelAttribute("updatedLists")
    List<ShoppingList> getShoppingLists(){
        return service.findAll();
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



