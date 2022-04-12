package com.ilegra.bidding.service;

import com.ilegra.bidding.model.Supplier;
import com.ilegra.bidding.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SupplierService {

  private final SupplierRepository supplierRepository;

  public Mono<Supplier> create(Supplier supplier) {
    return supplierRepository.save(supplier);
  }

}
