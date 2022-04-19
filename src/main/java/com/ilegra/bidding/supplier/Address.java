package com.ilegra.bidding.supplier;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String streetName;
    private String number;
    private String complement;
    private String zipCode;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
}
