package com.liu.EdvinasSecurityTwo.carParts.service;

import com.liu.EdvinasSecurityTwo.carParts.dto.CarPartRequest;
import com.liu.EdvinasSecurityTwo.carParts.dto.CarPartResponse;
import com.liu.EdvinasSecurityTwo.carParts.mapper.CarPartMapper;
import com.liu.EdvinasSecurityTwo.carParts.model.CarPart;
import com.liu.EdvinasSecurityTwo.carParts.model.Supplier;
import com.liu.EdvinasSecurityTwo.carParts.repository.CarPartRepository;
import com.liu.EdvinasSecurityTwo.carParts.repository.SupplierRepository;
import com.liu.EdvinasSecurityTwo.exceptions.CarPartNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarPartService {

    private final CarPartRepository carPartRepository;
    private final SupplierRepository supplierRepository;
    private final CarPartMapper carPartMapper;

    public List<CarPart> getAllCarParts() {
        return carPartRepository.findAll();
    }

    public void addNewCarPart(CarPartRequest request) {
        Supplier supplier = supplierRepository.findById(request.supplierId())
                .orElseThrow(RuntimeException::new);
        supplier.getCarPartList().add(request.carPart());
        supplierRepository.save(supplier);
    }

    public CarPartResponse updateCarPart(CarPartRequest request, Long id) {
        var carPart = carPartRepository.findById(id)
                .orElseThrow(()-> new CarPartNotFoundException("Car part not found with id: " + id));

        if (!request.carPart().getDescription().isEmpty()) {
            carPart.setDescription(request.carPart().getDescription());
        }
        if (request.carPart().getStock() != null) {
            carPart.setStock(request.carPart().getStock());
        }
        if (!request.carPart().getName().isEmpty()) {
            carPart.setName(request.carPart().getName());
        }

        return carPartMapper.toCarPartResponse(carPartRepository.save(carPart));
     }

    public void deleteCarPartById(Long id) {
        carPartRepository.findById(id)
                .orElseThrow(()-> new CarPartNotFoundException("Not found part with id: " + id));
        carPartRepository.deleteById(id);
    }
}
