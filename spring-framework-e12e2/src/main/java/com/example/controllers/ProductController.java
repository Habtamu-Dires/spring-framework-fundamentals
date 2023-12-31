package com.example.controllers;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
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
    private ProductRepository productRepository;

    @GetMapping("/all")
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    @GetMapping("/all/{name}")
    public List<Product> findAll(@PathVariable String name){
        return productRepository.findProductByName(name);
    }
}
