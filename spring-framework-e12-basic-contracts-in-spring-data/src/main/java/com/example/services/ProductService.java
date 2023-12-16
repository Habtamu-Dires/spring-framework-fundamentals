package com.example.services;

import com.example.entities.Product;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllSortedDescendingById() {
        return productRepository.findAll(Sort.by("id").descending());
    }

    public List<Product> getProductByPage(Integer page) {
        return productRepository.findAll(PageRequest.of(page, 2)).getContent();
    }

    public List<Product> getProductByPageAndSort(Integer page) {
        Sort sort = Sort.by("id").descending();
        return productRepository.findAll(PageRequest.of(page, 2, sort)).getContent();
    }

    public List<Product> getProductByName(String name, Integer page) {
//        Pageable p = PageRequest.of(page, 2); //pageable with out sort
        Pageable p = PageRequest.of(page, 2, Sort.by("id").descending());

        return productRepository.findProductsByName(name,  p);
    }
}
