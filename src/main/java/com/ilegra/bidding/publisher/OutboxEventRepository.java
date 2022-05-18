package com.ilegra.bidding.publisher;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxEventRepository extends ReactiveMongoRepository<OutboxEvent, String> {

}
