package org.example;

import org.example.config.ProjectConfig;
import org.example.services.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){

            HelloService service = c.getBean(HelloService.class);
            String message = service.hello("John");
            System.out.println("The result is " + message);
        }
    }
}



/**
 * AOP - Aspect Oriented Programming
 * IoC - Inversion of Control.
 * - is concept that the application is being controlled by the framework instead of
 *   controlled by the class that we write.
 *   e.g. we use annotation to add meta-data that tell spring how to control our classes.
 *
 * Another ideas of IoC -> how to manage indirectly the execution of your methods.
 * AOP -> decouple the method. Intercept the execution of a method.
 * AOP use case -> Transaction, logging or security
 *
 * //chapGpt
 * AOP -> is a programming paradigm that allows developers to modularize cross-cutting
 *   cutting concerns that affect multiple port of programs.
 *   The Primary goal of AOP is to promote modularity, maintainability and re-usability.
 * Key concepts in AOP includes:
 * ->Aspect: is a module that encapsulates a cross-cutting concern.
 *     -it defines certain behaviors that can be applied across multiple components in a modular way
 * ->Advice: is the actual code that gets executed when a specific point in the program (joint point)
      is reached.
 * -> Weaving - is the process of integrating aspects into the application at specified join point
 *    during the application's lifecycle. Two type of Weaving compile-time and run-time weaving
 *    here since we are using spring context , it is run-time Weaving.
 */

/**
 * try(){  //try-with-resource statement related to classes that implement auto-closable interface
 * if you create a object using try() with java ensures that the 'close' method is called
 * when the block is exited.(normally or due to an exception)
 * it is good for resource management b/c resources are properly released or closed.
 *  what is closing the context -> allows beans to perform necessary cleanup (release resources)
 *  and releasing any resources held by the context.
 * }
 */