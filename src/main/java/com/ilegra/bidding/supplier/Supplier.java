package com.ilegra.bidding.supplier;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
  private String cnpj;
  private List<String> phones;
  private String email;
  private Contact contact;
  private Address address;

}