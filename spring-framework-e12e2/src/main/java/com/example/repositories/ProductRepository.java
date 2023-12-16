package com.example.repositories;

import com.example.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
    // no magic method name, you have to provide native queries, off curse no jpql here
    @Query("SELECT * FROM product WHERE name=:name")
    List<Product> findProductByName(String name);
}
