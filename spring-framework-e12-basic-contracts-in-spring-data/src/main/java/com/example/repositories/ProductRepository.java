package com.example.repositories;

import com.example.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    //this is wrong b/c can't use both sort & pageable once if you want both pass sort to pageable
    //List<Product> findProductsByName(String name,Sort s, Pageable p);
    List<Product> findProductsByName(String name, Pageable p);
}
