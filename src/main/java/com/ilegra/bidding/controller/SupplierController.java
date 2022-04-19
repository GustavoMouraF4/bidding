package com.ilegra.bidding.controller;


import com.ilegra.bidding.supplier.Supplier;
import com.ilegra.bidding.supplier.SupplierService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/suppliers")
@Slf4j
public class SupplierController {

  private final SupplierService supplierService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Supplier> create(@RequestBody Supplier supplier) {
    return supplierService.create(supplier);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Flux<Supplier> findAll(@RequestParam(required = false) List<String> name) {
    return supplierService.findAll(name);
  }
}
