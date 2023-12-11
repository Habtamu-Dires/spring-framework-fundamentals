package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Owner {

//    private Cat cat = new Cat(); //this will create a cat but not the one form the context

    @Autowired     // ->find form the context of type Cat and give to cat filed in this bean.
    @Qualifier("cat2") //to identify the beans instance in the context when creating bean using @Bean annotation only
    private Cat cat;

//    @Autowired(required = false)    // required -> false not to force the existence of a cat in the context it but bad.
//    private Cat cat;

//    //second way of using @Autowired is to use a constructor and make the attribute immutable
//    private final Cat cat;
//    @Autowired
//    public Owner(Cat cat){  // the spring context find the Cat type and give to parameter 'cat'
//        this.cat = cat;
//    }
//    //third way to use @Autowired at setter methods
//    private Cat cat;

    public Cat getCat() {
        return cat;
    }

// third way of injection
//    @Autowired            // inject using setter methods
//    public void setCat(Cat cat) {
//        //do some other stuff
//        this.cat = cat;
//    }


    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "cat=" + cat +
                '}';
    }
}
