package org.example.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello(String name){
        String message =  "Hello, " + name + "!";
        System.out.println(message);
       return message;
//        throw new RuntimeException("Booo!");
    }
}

/**
 * Here you don't see anything about the method being intercepted . it is clean code.
 */
