package com.example.controllers;

import com.example.service.NumberService;
import com.example.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private NumberService numberService;

    @GetMapping("/home")
    public String indexAction(Model model){

        model.addAttribute("message", numberService.getValue());
        return "index.html";  //search for the view in resources/templates
    }
}

/**
 * This IndexController bean is singleton - that is has only one instance in the context.
 * How can inject a REQUEST_SCOPE bean (beans per request) to singleton bean?
   using proxy to manage beans (new beans per request), behind this proxy is AOP.
 *
 * In Real world use abstraction (interfaces) -> and inject interface type if only one bean available
   spring is smart enough to inject the implementation of that interface.
   e.g NumberService interface
 */




