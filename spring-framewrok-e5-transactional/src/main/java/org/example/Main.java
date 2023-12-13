package org.example;

import org.example.config.ProjectConfig;
import org.example.services.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductService ps = c.getBean(ProductService.class);

            ps.addOneProduct();
        }
    }
}