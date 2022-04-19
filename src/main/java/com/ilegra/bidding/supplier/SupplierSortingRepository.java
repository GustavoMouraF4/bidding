package com.ilegra.bidding.supplier;


import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SupplierSortingRepository extends ReactiveSortingRepository<Supplier, String> {

  Flux<Supplier> findAllByNameContains(String name, Pageable pageable);

}
