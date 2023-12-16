package com.example.controllers;

import com.example.dto.ProductDTO;
import com.example.entities.Product;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/add")
    public void addProduct(@RequestBody ProductDTO p){
        productService.addProduct(p);
    }

    @GetMapping(path = "/get/{name}")
    public Product getProduct(@PathVariable("name") String name){
        return productService.getProduct(name);
    }
}
