package com.ilegra.bidding.supplier;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends ReactiveMongoRepository<Supplier, String> {

}
