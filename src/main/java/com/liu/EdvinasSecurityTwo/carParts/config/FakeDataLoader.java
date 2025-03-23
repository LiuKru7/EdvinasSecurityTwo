package com.liu.EdvinasSecurityTwo.carParts.config;

import com.liu.EdvinasSecurityTwo.carParts.model.CarPart;
import com.liu.EdvinasSecurityTwo.carParts.model.Supplier;
import com.liu.EdvinasSecurityTwo.carParts.repository.CarPartRepository;
import com.liu.EdvinasSecurityTwo.carParts.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FakeDataLoader implements CommandLineRunner {

    private final CarPartRepository carPartRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public void run(String... args) throws Exception {

        var supplier = Supplier.builder()
                .address("Moliugu 4")
                .email("email@eemail.com")
                .build();

        var part1 = CarPart.builder()
                .name("Ratas")
                .stock(4)
                .description("R17")
                .supplier(supplier)
                .build();

        var part2 = CarPart.builder()
                .name("Guolis")
                .stock(4)
                .description("NJ207")
                .supplier(supplier)
                .build();

        supplier.setCarPartList(List.of(part1,part2));

        supplierRepository.save(supplier);

    }
}
