package org.example;

import org.example.config.ProjectConfig;
import org.example.model.Product;
import org.example.repositories.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){

            ProductRepository productRepository = c.getBean(ProductRepository.class);
//            Product p = new Product();
//            p.setName("Burger");
//            p.setPrice(5.0);
//
//            productRepository.addProduct(p);

            List<Product> products = productRepository.getProducts();
            products.forEach(System.out::println);

        }
    }
}