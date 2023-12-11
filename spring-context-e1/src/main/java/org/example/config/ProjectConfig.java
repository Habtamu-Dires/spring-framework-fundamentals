package org.example.config;

import org.example.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//@ComponentScan(basePackages = "org.example.beans") // scan for class that are annotated with stereotype annotations in the beans package
@ComponentScan(basePackages = {"org.example.services", "org.example.repositories"})
public class ProjectConfig {

    /** first method of creating place instance of class inside a context */
//    @Bean(name = "A")  // name or value used to give bean name , default bean name is method name
//    //@Primary  //use it if you have more than one instance of some class in the context and use bean by type.
//    public MyBean myBean1() {
//        MyBean b = new MyBean();
//        b.setText("Hello");
//        return b;
//    }
//
//    @Bean
//    public MyBean myBean2() {
//
//        MyBean b = new MyBean();
//        b.setText("World");
//        return b;
//    }
    /**
     *  second method of creating and  placing instance of class inside a context is using stereotype annotations.
     *  which is directly applied on the class of MyBean
     *  Stereotype annotaitons - @Component, @Service, @Repository and @Controller.
     * */
}
