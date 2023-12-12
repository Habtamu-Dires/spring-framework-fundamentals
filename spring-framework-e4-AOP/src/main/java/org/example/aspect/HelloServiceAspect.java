package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * An aspect is a decoupled (separated) pace of code the intercept a specific group of methods.
 * it can be before execution of a method , after the execution of a method , or
 * when exception occur.
 */

@Aspect  //this just define aspect, it doesn't add an instance in the spring context, we have to do ourself using stereotype or using @Bean
@Component
public class HelloServiceAspect {


//    // execute the method before the execution of the method listed execute this
//    @Before("execution(* org.example.services.HelloService.hello(..))") // the values specify  which is a group of method to intercept
//    public void before(){
//        System.out.println("A");
//    }
//
//    //after the execution of the method listed execute this, no matter exception
//    @After("execution(* org.example.services.HelloService.hello(..))")
//    public void after(){
//        System.out.println("B");
//    }
//
//    //executes only if the execution of a method happen without any exception
//    @AfterReturning("execution(* org.example.services.HelloService.hello(..))")
//    public void afterReturning(){
//        System.out.println("C");
//    }
//
//    //executes only if the execution of a method throws out an exception.
//    @AfterThrowing("execution(* org.example.services.HelloService.hello(..))")
//    public void afterThrowing(){
//        System.out.println("D");
//    }

    //before , after and even the method throw exception. many dangers  thing can be done here.
    @Around("execution(* org.example.services.HelloService.hello(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        /** here the jointPoint parameter represents the method bing intercepted
         * if we don't use this parameter(jointPoint) the execution of the method will to happen.
         * one can do so many thing like get the argument passed to method (getArgs()), getSignature(),
         * */

        System.out.println("A");
        Object result = null;
        try {

            result = joinPoint.proceed();  // let the intercepted method run. the method my throw exception.
            // replace the parameter given to the method. -> output is Hello, Bill replacing the Bill
            //result = joinPoint.proceed(new Object[]{"Bill"});

            System.out.println("B");
        } catch (Throwable e) {
           e.printStackTrace();
        }
        return result;
        //return "Something else!!!";
    }

}

/**
 * The @Before , @After ... are join-points , a specific points in the intercepted methods.
 */
