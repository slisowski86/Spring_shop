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
    String showCreateGroupForm(Model model, @ModelAttribute("list") ShoppingList currentList)

    {



        model.addAttribute("products", productService.findAll());
        model.addAttribute("list", new ShoppingList() );


        return "shoppingLists/new";
    }
    @PostMapping(value ="/new" ,produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addList(@ModelAttribute("list") ShoppingList currentList, Model model){
        logger.info(currentList.getName());






        service.save(currentList);

        return "redirect:/lists/addProducts/" + currentList.getId();




    }

    /*@PostMapping(params="addNewProduct", value="/new")
    String addNewProduct(Model model,@ModelAttribute("list") ShoppingList currentList, @ModelAttribute("productList") ProductListWrapper productList, @RequestParam("id") Long id){


        model.addAttribute("productList", productList);
        Product product = productService.findById(id);
        productList.add(product);

        for(Product p: productList.getProductList()){
            System.out.println(p.getName());
        }

        return "shoppingLists/new";
    }*/








   /* @PostMapping(params = "addProduct" , value ="/new" ,produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String addListProduct(@ModelAttribute("list") ShoppingList currentList, @ModelAttribute("productsToAdd") ProductList productList, @RequestParam(value="idList[]", required = false) List<Long> idList,
                   Model model) {



        model.addAttribute("productsToAdd", idList);
        idList.add()








        return "shoppingLists/new";

    }*/







    @GetMapping("/addProducts/{shoppingListId}")
    public ModelAndView showShoppingList(@PathVariable Long shoppingListId,
    @ModelAttribute("product") Product product, @ModelAttribute("newList") ShoppingList currentList) {

        ModelAndView mav = new ModelAndView("shoppingLists/addProducts");
        mav.addObject("newList", service.findById(shoppingListId));
        mav.addObject("products", productService.findAll());


        mav.addObject("productsList", shoppingListProductService.findProducts(shoppingListId));


        return mav;
    }

    @PostMapping("/addProducts/{shoppingListId}")
    public String addProduct(Model model, @RequestParam("id") Long id, @PathVariable Long shoppingListId){
        Product product= productService.findById(id);
        ShoppingList list = service.findById(shoppingListId);

        service.addProduct(product, list);
        service.saveOrUpdate(list);

        return "redirect:/lists/addProducts/" + list.getId();


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



