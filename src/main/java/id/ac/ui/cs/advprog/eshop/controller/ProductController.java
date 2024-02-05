package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller


public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/product/create")
    public String createProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "createProduct";
    }

    @PostMapping("/product/create")
    public String createProductPost(@ModelAttribute Product product,Model model){
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/product/list")
    public String productListPage(Model model){
        List<Product> allProducts = service.findAll();
        model.addAttribute("products",allProducts);
        return "productList";
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") String productId){
        service.delete(productId);
        return "redirect:/product/list";
    }

    @GetMapping("/product/edit/{productId}")
    public String editProductPage(Model model,@PathVariable String productId){
        Product product = service.get(productId);
        model.addAttribute("product",product);
        return "EditProduct";
    }

    @PutMapping(value="/product/edit/{productId}")
    public String editProduct(@ModelAttribute Product productUpdate){
        service.update(productUpdate);
        return "redirect:/product/list";
    }

}
