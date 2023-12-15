package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody    // class or method level annotation
@RestController  // this like @Controller + @ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    //@ResponseBody // do not search in static just response
    public String hello(){
        return "Hello";
    }

}
