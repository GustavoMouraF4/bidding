package com.ilegra.bidding.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Supplier {

  @Id
  private String id;
  private String name;

}
