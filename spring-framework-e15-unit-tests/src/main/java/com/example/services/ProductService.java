package com.example.services;

import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<String> getProductEvenNames(){
        List<String> names = productRepository.getProductNames();

        return names.stream()
                .filter(name -> name.length() % 2 == 0)
                .toList();

        /*List<String> result = new ArrayList<>();

        for(String n : names){
            if(n.length() % 2 == 0){
                result.add(n);
            }
        }

        return result;*/
    }
}
/**
 * One use of test is when we refactor the code / change the code implementation while
   keeping the logic. The test helps us to make sure that the logic is the same.
   e.g. see the above two cases, using for loop and stream() both to find even length words.

 */
