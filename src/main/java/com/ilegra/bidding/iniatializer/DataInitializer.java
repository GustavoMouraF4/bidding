package com.ilegra.bidding.iniatializer;

import com.github.javafaker.Faker;
import com.ilegra.bidding.supplier.Address;
import com.ilegra.bidding.supplier.Contact;
import com.ilegra.bidding.supplier.Supplier;
import com.ilegra.bidding.supplier.SupplierRepository;
import com.ilegra.bidding.supplier.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final SupplierService supplierService;

    @Override
    public void run(String... args) {
        List<Supplier> suppliers = new ArrayList<>();
        Faker faker = new Faker(new Locale("pt-BR"));
        for (int i = 0; i < 20; i++) {
            Supplier supplier = Supplier.builder()
                    .cnpj(faker.number().digits(14))
                    .name(faker.company().name())
                    .phones(List.of(faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone()))
                    .email(faker.internet().emailAddress())
                    .contact(Contact.builder().firstName(faker.dog().name())
                            .lastName(faker.name().lastName())
                            .build())
                    .address(Address.builder()
                            .streetName(faker.address().streetName())
                            .number(String.valueOf(faker.number().randomNumber(10000, false)))
                            .complement(String.valueOf(faker.number().randomNumber(10000, false)))
                            .neighborhood(faker.funnyName().name())
                            .zipCode(faker.address().zipCode())
                            .city(faker.address().city())
                            .state(faker.address().state())
                            .country(faker.address().country())
                            .build())
                    .build();
            suppliers.add(supplier);
        }
        supplierService.createMany(suppliers)
                .subscribe();
    }
}