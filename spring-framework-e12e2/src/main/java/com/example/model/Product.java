package com.example.model;

import org.springframework.data.annotation.Id;

public class Product {

    // watch here id no from JPA (javax/Jakartax.persistence.Annotation) + no @Entity
    @Id
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
