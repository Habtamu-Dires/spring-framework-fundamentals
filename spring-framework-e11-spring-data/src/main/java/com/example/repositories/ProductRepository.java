package com.example.repositories;

import com.example.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
//you will get the implementation this interface at run time by spring-data-jpa --> magic
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    //magic method - with rules
//   public Product findProductByName(String name);

   //jpql query why not the above? what if someone refactor the name
    @Query("SELECT p FROM Product p WHERE p.name=:name")
    public Product findProductByName(String name);
}
