package com.ilegra.bidding.controller;

import com.ilegra.bidding.model.Supplier;
import com.ilegra.bidding.repository.SupplierRepository;
import com.ilegra.bidding.service.SupplierService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = SupplierController.class)
@Import(SupplierService.class)
public class SupplierControllerTest {

    @MockBean
    private SupplierRepository supplierRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldCreateSupplier() {
        Supplier supplier = Supplier.builder()
                .name("Gustavito Gustavito")
                .build();

        Mockito.when(supplierRepository.save(supplier))
                .thenAnswer(answer -> {
                    supplier.setId(UUID.randomUUID().toString());
                    return Mono.just(supplier);
                });

        Supplier result = webTestClient
                .post()
                .uri("/v1/suppliers")
                .body(BodyInserters.fromValue(supplier))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(Supplier.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals("Gustavito Gustavito", result.getName());
    }
}
