package org.example.services;

import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDeliveryService {

//    @Autowired   //get it form the context and use the value here.
    private ProductRepository productRepository;

//    private final ProductRepository productRepository;  // use constructor way can achieve immutability
//    @Autowired
//    public ProductDeliveryService(ProductRepository productRepository){
//        this.productRepository = productRepository;
//    }

    public void addSomeProducts(){
        productRepository.add();
        productRepository.add();
        productRepository.add();
    }
}
