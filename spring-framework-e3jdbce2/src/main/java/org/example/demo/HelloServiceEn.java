package org.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier  // @Qualifier needs a name no default name like @Bean methods
@Primary  //when we have two or more similar beans that implement same interface
// at stereotype level @Primary used to make one primary
public class HelloServiceEn implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
