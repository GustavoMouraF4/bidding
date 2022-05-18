package com.ilegra.bidding.supplier;

import com.ilegra.bidding.publisher.PublishService;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierService {

  private final SupplierRepository supplierRepository;
  private final SupplierSortingRepository supplierSortingRepository;
  private final PublishService publishService;

  public Mono<Supplier> create(Supplier supplier) {
    return supplierRepository.save(supplier)
        .flatMap(savedSupplier -> publishService.publishToOutbox(savedSupplier)
            .thenReturn(savedSupplier));
  }

  public Flux<Supplier> findAll(List<String> name) {
//    return supplierSortingRepository.findAllByNameContains("", PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "name")));
    return supplierRepository.findAll(Example.of(Supplier.builder().name("Aparício Comércio").build()));
  }

  public Flux<Supplier> createMany(List<Supplier> suppliers) {
    return supplierRepository
        .insert(suppliers)
        .flatMap(supplier -> publishService
            .publishToOutbox(supplier)
            .thenReturn(supplier));
  }

}
