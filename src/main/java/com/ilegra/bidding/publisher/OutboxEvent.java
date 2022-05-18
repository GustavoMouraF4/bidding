package com.ilegra.bidding.publisher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OutboxEvent {

  @Id
  private String id;
  private String topic;
  private String payload;

}
