package com.github.slisowski.Spring_shop.controller;


import com.github.slisowski.Spring_shop.logic.service.ShoppingListProductService;
import com.github.slisowski.Spring_shop.logic.servicerepo.ProductRepoService;
import com.github.slisowski.Spring_shop.logic.servicerepo.ShoppingListRepoService;
import com.github.slisowski.Spring_shop.model.Product;
import com.github.slisowski.Spring_shop.model.ProductRepository;
import com.github.slisowski.Spring_shop.model.ShoppingList;
import com.github.slisowski.Spring_shop.model.ShoppingListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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



    ShoppingListController(final ShoppingListRepoService service, final ProductRepository repository, final ShoppingListRepository shoppingListRepository, final ProductRepoService productService, final ShoppingListProductService shoppingListProductService, final ShoppingListProductService shoppingListProductService1) {
        this.service = service;
        this.repository = repository;
        this.shoppingListRepository = shoppingListRepository;
        this.productService = productService;

        this.shoppingListProductService = shoppingListProductService;
    }



   /* private final ShoppingListRepository repository;
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
        model.addAttribute("list", new ShoppingList() );


        return "shoppingLists/new";
    }
    @PostMapping(value ="/new" ,produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addList(@ModelAttribute("list") ShoppingList currentList, Model model){
        logger.info(currentList.getName());

        Product product= productService.findById(2L);
        Product product1= productService.findById(5L);
        Product product2= productService.findById(4L);
        Product product3= productService.findById(6L);






        service.addProduct(product, currentList);
        service.addProduct(product1, currentList);
        service.addProduct(product2, currentList);
        service.addProduct(product3, currentList);




        service.save(currentList);

        return "redirect:/lists/addProducts/" + currentList.getId();




    }

   /* @PostMapping(params = "addProduct" , value ="/new" ,produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addListProduct(@ModelAttribute("list") ShoppingList currentList, @ModelAttribute("productsToAdd") ProductList productList, @RequestParam(value="idList[]", required = false) List<Long> idList,
                   Model model) {



        model.addAttribute("productsToAdd", idList);
        idList.add()








        return "shoppingLists/new";

    }*/




    @PostMapping(params = "addProduct")
    public String addProduct(@ModelAttribute ("newList") ShoppingList currentList, @ModelAttribute("productsList") List<Product> productList){
        Product product=productService.findById(1L);
        service.addProduct(product, currentList);
        logger.info("Dodano "+product.getName());
        return "redirect:/lists/addProducts/" + currentList.getId();
    }


    @GetMapping("/addProducts/{shoppingListId}")
    public ModelAndView showShoppingList(@PathVariable Long shoppingListId,
    @ModelAttribute("product") Product product) {

        ModelAndView mav = new ModelAndView("shoppingLists/addProducts");
        mav.addObject("newList", service.findById(shoppingListId));


        mav.addObject("productsList", shoppingListProductService.findProducts(shoppingListId));


        return mav;
    }

    @GetMapping("/addProducts")
    public String showShoppingList() {



        return "shoppingLists/addProducts";
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



