package org.example.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductRepository {

    //you know @Autowired works only inside a bean. here b/c @Repository.
    //@Autowired(required=false) // don't throw an error, if you don't find this bean.
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @PostConstruct
//    public void init(){  //this method will be called after injected all dependencies.
//    }

    public void addProduct(String name){
        String sql = "INSERT INTO product VALUES(NULL, name);";
        jdbcTemplate.update(sql, name);
    }

}


