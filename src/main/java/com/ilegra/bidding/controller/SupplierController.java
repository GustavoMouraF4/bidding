package com.ilegra.bidding.controller;


import com.ilegra.bidding.model.Supplier;
import com.ilegra.bidding.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {

  private final SupplierService supplierService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Supplier> create(@RequestBody Supplier supplier) {
    return supplierService.create(supplier);
  }
}
