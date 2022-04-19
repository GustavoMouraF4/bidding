package com.ilegra.bidding.supplier;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Contact {

    private String firstName;
    private String lastName;

}
