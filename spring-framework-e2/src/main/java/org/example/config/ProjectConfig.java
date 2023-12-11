package org.example.config;

import org.example.beans.Cat;
import org.example.beans.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"org.example.beans"})
public class ProjectConfig {

//    @Bean
//    public Cat cat(){       //these methods that will return instance that will be in context.
//        Cat c = new Cat();
//        c.setName("Tom");
//        return c;
//    }
//
//    @Bean
//    public Owner owner(Cat cat){  // spring will inject the available type(Cat) from the context to this bean
//        Owner o = new Owner();
////        o.setCat(new Cat()); // this cat is out-side of the context
////        // calling cat(),  does call directly the cat() method, spring first check in the context
////        o.setCat(cat()); // spring will give the owner the cat instance that already in the context.
//        o.setCat(cat);  // or this other way from parameter
//        return o;
//    }

    //let have multiple instance of cats
//
    @Bean
    @Qualifier("cat1")  // default is the method name
    public Cat cat1(){
        Cat c = new Cat();
        c.setName("Tom");
        return c;
    }

    @Bean
    //@Qualifier("cat2")   // even if we do use it will ba accessed via Qualifier using method name
    public Cat cat2(){
        Cat c = new Cat();
        c.setName("Leo");
        return c;
    }
}
