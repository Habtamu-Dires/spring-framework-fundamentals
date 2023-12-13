package org.example.services;

import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // AOP is behind the implementation of @Transactional
    //the transaction will start at beginning of the method and committed at the end of the method.
    /*@Transactional(noRollbackFor = RuntimeException.class)
    ..rollbackFor and noRollbackFor -> attributes to change the default behaviour when and when not to roll back*/
    @Transactional
    public void addOneProduct() {
        productRepository.addProduct("Beer");

        /** Will the below try-catch rollback the transaction ? No b/c the transaction is treated / caught here.
         * It is not only about throwing exception in the method , it should have to be propagated  outside the method.
         * This is because of the Aspect Weaving around the method if the exception is never thrown out of the method
         * the Aspect will not see the exception and will never roll back the transaction.
         * */

        try {
            throw new RuntimeException(":(");
        } catch (RuntimeException e){
            e.printStackTrace();
        }

//        //only for RuntimeExceptions that cause by default rollback in the transaction
//        throw new RuntimeException(":(");

//         throw new Exception(":(");  // for checked exception, the transaction will not be roll back.
    }
}
