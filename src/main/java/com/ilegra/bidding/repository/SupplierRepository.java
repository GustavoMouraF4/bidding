package com.ilegra.bidding.repository;

import com.ilegra.bidding.model.Supplier;
import java.util.UUID;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends ReactiveMongoRepository<Supplier, UUID> {

}
