package com.example.controllers;

import com.example.dto.PersonDTO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    //@RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    @GetMapping(path = "/hello/{name}")  //the same with the above
    public String hello(@PathVariable("name") String name){
        return "Hello, " + name +"!";
    }

    @PostMapping(path = "/goodbye")
    public String goodbye(@RequestBody PersonDTO p){   //@GetBody convert the up-coming json to DTO
        return "Goodbye, " + p.getName() + "!";
    }

    @GetMapping(path = "/get")
    public PersonDTO getPerson(){
        PersonDTO p = new PersonDTO();
        p.setName("Bill");

        return p;
    }

    @GetMapping(path = "/getall")
    public List<PersonDTO> getAllPersons(){
        PersonDTO p1 = new PersonDTO();
        p1.setName("Bill");

        PersonDTO p2 = new PersonDTO();
        p2.setName("John");

        return List.of(p1, p2);
    }

    @GetMapping("/status-test")
    public void statusTest(HttpServletResponse response){ // inject the response and let's manipulate it.
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @GetMapping("/test")
    public PersonDTO test(HttpServletResponse response){
        PersonDTO p1 = new PersonDTO();
        p1.setName("Bill");

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return  p1;
    }
}

/**

@RestController this is a combination of @Controller + @ResponseBody that tell spring boot
 to add it to a context as a bean + all methods in this class returns goes directly to the client.

HttpServletResponse - interface represents the response of type Http
 */
