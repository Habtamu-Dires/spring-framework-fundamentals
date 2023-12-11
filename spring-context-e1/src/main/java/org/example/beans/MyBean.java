package org.example.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;



/**
 * A Bean is a class whose instance will be placed in context
 * one can create a bean of a class first using @Bean annotation in configuration class
 * or using stereotype annotation at class level
 * using Stereotype you can only create one instance of a class
 */
@Component
public class MyBean {

    private String text;
    // @PostConstruct only works with bean in that are found in spring context.
    //@PostConstruct used to mark a method as a callback method. can be used with stereotype or @Bean annotations
    @PostConstruct  // this method should be invoked after the bean has been instantiated.
    private void init(){
        this.text = "HELLO";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
