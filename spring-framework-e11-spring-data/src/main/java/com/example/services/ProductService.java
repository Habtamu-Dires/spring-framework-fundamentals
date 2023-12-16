package com.example.services;

import com.example.dto.ProductDTO;
import com.example.entities.Product;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDTO p){
        Product product = new Product();
        product.setName(p.getName());
        productRepository.save(product);
    }

    public Product getProduct(String name){
        return productRepository.findProductByName(name);
    }
}
