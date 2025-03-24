package com.liu.EdvinasSecurityTwo.carParts.service;

import com.liu.EdvinasSecurityTwo.carParts.dto.CarPartRequest;
import com.liu.EdvinasSecurityTwo.carParts.model.CarPart;
import com.liu.EdvinasSecurityTwo.carParts.model.Supplier;
import com.liu.EdvinasSecurityTwo.carParts.repository.CarPartRepository;
import com.liu.EdvinasSecurityTwo.carParts.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarPartService {

    private final CarPartRepository carPartRepository;
    private final SupplierRepository supplierRepository;

    public List<CarPart> getAllCarParts() {
        return carPartRepository.findAll();
    }

    public void addNewCarPart(CarPartRequest request) {
        Supplier supplier = supplierRepository.findById(request.supplierId())
                .orElseThrow(RuntimeException::new);
        supplier.getCarPartList().add(request.carPart());
        supplierRepository.save(supplier);
    }
}
