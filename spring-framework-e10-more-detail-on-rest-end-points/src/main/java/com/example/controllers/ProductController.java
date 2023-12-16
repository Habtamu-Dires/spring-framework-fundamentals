package com.example.controllers;

import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")  //when used at class level, pre-fix all the method with this '/product'
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/add/{name}")
    public void addProduct(@PathVariable("name") String name){
        productService.addProduct(name);
    }
}
