package org.example.services;

import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void addTenProducts(){
        for(int i=1; i<=10; i++){
            productRepository.addProduct("Product " + i);
            if(i==5) throw new RuntimeException(":(");
        }
    }
}

