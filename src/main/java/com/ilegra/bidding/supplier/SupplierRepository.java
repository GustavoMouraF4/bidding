package com.ilegra.bidding.supplier;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SupplierRepository extends ReactiveMongoRepository<Supplier, String> {

  @Query("{ 'name': { $in: ?0 } }")
  Flux<Supplier> findSuppliersByName(List<String> name);

}
