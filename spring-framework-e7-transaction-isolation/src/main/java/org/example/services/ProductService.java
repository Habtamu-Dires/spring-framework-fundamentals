package org.example.services;

import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(isolation = Isolation.DEFAULT )
    public void addTenProducts(){
        for (int i=1; i<=10; i++){
            productRepository.addProduct("Product " + i);
        }
    }
}
/**
 * Transaction isolation refers to the degree to which one transaction is isolated from the
   effect of other transactions.
 *. It ensures that each transaction operates independently of others, and changes made
   by one transaction are not visible to other transactions until the changes are committed.

 *imagine a scenario where multiple transactions are happening concurrently. Isolation ensures
   - that one transaction doesn't interfere with another while they are in progress. It's like each
   - transaction is working in its own private space until it's ready to share its results with the rest of the system.
*Isolation Levels vary in terms of how much they isolate transactions from each other,
  with higher levels offering more isolation but potentially impacting performance


 * DEFAULT ---> read committed -> depends on the datasource layer
 *
 * READ_UNCOMMITTED
 * READ_COMMITTED
 * REPEATABLE_READ
 * SERIALIZABLE
 *
 * PROBLEMS:
 * - dirty reads
 * - repeatable reads
 * - phantom reads
 *
 *Dirty Reads:
 *T1 -----x?10-----------------x?20---------------> 20?  x?10 -> read the value of x
 *
 * T2--------------x=>20----------------R----------> // the transaction change x to 20  rollback (R) before commit
 *
 * Dirty reads - Transaction one (T2) changes x to 20 but never committed or rollback.
   and Transaction Two reads x in between and reads to be 20 which is sth value that never committed.
   This happens that T1 see the changed values in T2 in isolation type of READ_UNCOMMITTED.

 * READ_COMMITTED -> dirty reads can not occur here.
 * --but READ_COMMITTED says read everything committed by other transactions.
 * repeatable reads: the same query with different time gives different result.
 *
 * T1 -----x?10-----------------x?20---------------> 20?
 *
 * T2--------------x=20-C--------------------------> //the transaction change x to 20 and  commit (C)
 *
 *REPEATABLE_READ Isolation Level-> avoid both dirty reads and repeatable reads
 *
 * phantom reads ->
 *
 * T1 -----N?100-----------------N?110---------------> 110  //T1 select 100 products then 110
 *
 * T2--------------x=x+10-C--------------------------> // T2 add 10 more product this 10 product is phantom product
 *
 * To avoid this phantom reads use SERIALIZABLE -> which is the lest performant.
 */
