package com.example.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    //getting a request header
    @GetMapping("/test")
    public String test(@RequestHeader String a,   //@RequestHeader get the request header
                       @RequestHeader String b,
                       @RequestHeader String c){

        return a + " " + b + " " + c ;

    }

    //using @PathVariable, @RequestHeader and @RequestBody all in one request.
    // N.b @RequestBody can not be used with @GetMapping - get verb
    @PostMapping("/test/{name}")
    public String testPost(@PathVariable("name") String name,
                           @RequestHeader String a,
                           @RequestHeader String b,
                           @RequestHeader String c,
                           @RequestBody String body,
                           HttpServletResponse response){
        response.setHeader("test", "good");       // set response header (test: good)
        return name + " " + a + " " + b + " " + c +" " + body;

    }

    //map and multiple RequestHeaders, when you don't know all the available headers, but you want to take all of them
    @GetMapping("/all")
    public Map<String, String> all(@RequestHeader Map<String, String> map){ //all headers will be collected as key value
                                                                                        // pari to the map
        return map;
    }

    //use produces -> change what the endpoint returns, the default is JSON
    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] file(){
        byte [] file = new byte[100];
        return file;
    }



}
