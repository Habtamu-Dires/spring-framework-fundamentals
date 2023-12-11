package org.example;

import org.example.beans.MyBean;
import org.example.config.ProjectConfig;
import org.example.repositories.ProductRepository;
import org.example.services.ProductDeliveryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /** Spring context is a collection of instance managed by spring.
     * the context in spring framework can be configured using :-
     * XML, Annotations (elements of a language to specify some meta-data)
     */
    public static void main(String[] args) {
        try(var context =
                    new AnnotationConfigApplicationContext(ProjectConfig.class)){
//            // get bean from the context by type
//
//            MyBean b1 = context.getBean(MyBean.class);
//            MyBean b2 = context.getBean(MyBean.class);
//
//            // get bean from the context by name -- no need of @Primary
////            MyBean b1 = context.getBean("A", MyBean.class);
////            MyBean b2 = context.getBean("myBean2", MyBean.class);
//
//            System.out.println(b1.getText());
//            System.out.println(b2.getText());


//            MyBean b = new MyBean(); // this is normal instance spring does not know about it.
//            System.out.println(b.getText()); // output is null b/c @PostConstruct doesn't work on normal instances


            ProductDeliveryService service = context.getBean(ProductDeliveryService.class);
            service.addSomeProducts();

        }
    }
}