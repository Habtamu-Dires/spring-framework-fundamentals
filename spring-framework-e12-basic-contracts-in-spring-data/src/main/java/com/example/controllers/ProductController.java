package com.example.controllers;

import com.example.entities.Product;
import com.example.repositories.ProductRepository;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/sort")
    public Iterable<Product> getAllSortedDescendingById(){
        return  productService.getAllSortedDescendingById();
    }

    @GetMapping("/page/{page}")
    public List<Product> getProductByPage(@PathVariable("page") Integer page){
        return productService.getProductByPage(page);
    }

    @GetMapping("/page&sort/{page}")
    public List<Product> getProductByPageAndSort(@PathVariable("page") Integer page){
        return productService.getProductByPageAndSort(page);
    }
    @GetMapping("/name/{name}/{page}")
    public List<Product> getProductByName(@PathVariable String name,
                                          @PathVariable Integer page){
         return productService.getProductByName(name, page);
    }
}
