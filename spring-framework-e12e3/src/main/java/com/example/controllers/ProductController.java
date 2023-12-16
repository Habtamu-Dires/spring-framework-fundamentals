package com.example.controllers;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/add/{name}")
    public void addProduct(@PathVariable String name){
        Product p = new Product();
        p.setName(name);
        productRepository.save(p);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
