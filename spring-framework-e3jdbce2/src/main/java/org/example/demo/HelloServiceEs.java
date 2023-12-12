package org.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("es")   // you can also @Qualifier to identify beans. N.B @Qualifier mustbe
public class HelloServiceEs implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Hola, " + name + "!";
    }
}
