package com.example.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    public List<String> getProductNames(){
        return List.of("aa","bbb","cccc","ddddd");
    }

    public void addProduct(String name){

    }
}
