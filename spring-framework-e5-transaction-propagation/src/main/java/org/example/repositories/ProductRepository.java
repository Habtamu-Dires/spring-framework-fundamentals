package org.example.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED) // class level @Transaction is like adding @Transaction at every method.
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW) // you can override properties
//    @Transactional
    public void addProduct(String name){
        String sql = "INSERT INTO product VALUES (NULL, ?);";
        jdbcTemplate.update(sql,name);
    }
}

/** Transaction propagation levels - can be seated using propagation parameter of @Transactional
 e.g @Transactional(propagation = Propagation.REQUIRED)
 ->propagation levels:
 *  REQUIRED (default)
 *  REQUIRES_NEW
 *  MANDATORY
 *  NEVER
 *  SUPPORTS
 *  NOT_SUPPORTED
 *  NESTED
 *
 *  REQUIRED ->  when called uses existing transaction(propagated) or creates new if there is no coming or
    propagated transaction coming from the caller.
    REQUIRED is Default Propagation level.
 *
 *  REQUIRES_NEW -> always create new transaction,
     even if there is a transaction (propagated) create a new one for target method and commit it at end the target method.
    but in case of REQUIRED it use the coming (the propagated transaction) does not create one it uses the existing one.
    - if you want to make suer that you donot depend on the transaction that from where
     you call the method, and  you want always create its own transaction form some reason use
     REQUIRES_NEW.
 *
 *  MANDATORY -> doesn't create a transaction, but it makes sure that the method is called inside
    a transaction. if it called without transaction it will throw an error.
    it uses the existing transaction just like REQUIRED.
    - This make sures that the method will never be called form non-transaction method.

 * NEVER -> opposite of transaction, -> run if there is no transaction
    throw exception, if there is propagated transaction ( or called form transactional method).
   - so such method can not be called in transaction method.
 *
 * SUPPORTS -> we can execute a method with a transaction(propagated),
   if no transaction none will be created.

 *NOT_SUPPORTED -> doesn't create a transaction.
   Used When you want to run a method without a transaction. since transaction create overhead.
   -execute a method on non-transactional context even if it is called in transactional context.

 *NESTED -> transaction inside a transaction.
     - if the outer transaction rollback it forces the inner transaction to rollback too.
    -Different from REQUIRED_NEW transaction b/c REQUIRED_NEW creates a separate new transaction
      so if the existing transaction roll back the created new transaction will not roll back.

 */

