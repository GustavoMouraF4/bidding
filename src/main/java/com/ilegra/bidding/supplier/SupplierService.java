package com.ilegra.bidding.supplier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SupplierService {

  private final SupplierRepository supplierRepository;

  public Mono<Supplier> create(Supplier supplier) {
    return supplierRepository.save(supplier);
  }

  public Flux<Supplier> findAll() {
    return supplierRepository.findAll();
  }
}
