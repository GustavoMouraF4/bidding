package com.ilegra.bidding.publisher;

import com.ilegra.bidding.supplier.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PublishService {

  private final OutboxEventRepository repository;

  public Mono<Void> publishToOutbox(Supplier supplierToPublish) {
    return Mono.just(supplierToPublish)
        .map(supplier -> OutboxEvent.builder()
             .topic("bidding.cmd")
             .payload(supplier.getName())
             .build())
        .flatMap(outbox -> repository.save(outbox))
        .then();
  }

}
