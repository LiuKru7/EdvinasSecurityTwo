package com.liu.EdvinasSecurityTwo.carParts.service;

import com.liu.EdvinasSecurityTwo.carParts.dto.SupplierRequest;
import com.liu.EdvinasSecurityTwo.carParts.dto.SupplierResponse;
import com.liu.EdvinasSecurityTwo.carParts.mapper.SupplierMapper;
import com.liu.EdvinasSecurityTwo.carParts.repository.SupplierRepository;
import com.liu.EdvinasSecurityTwo.exceptions.SupplierNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public List<SupplierResponse> getAllSupplier() {
        return supplierRepository.findAll().stream()
                .map(supplierMapper::SupplierToSupplierResponse)
                .toList();
    }

    public SupplierResponse addSupplier(SupplierRequest request) {
        var supplier = supplierMapper.SupplierRequestToSupplier(request);
        return supplierMapper.SupplierToSupplierResponse(supplierRepository.save(supplier));
    }

    public SupplierResponse updateSupplier(SupplierRequest request, Long id) {
        var supplier = supplierRepository.findById(id)
                .orElseThrow(()-> new SupplierNotFoundException("Supplier with id: " + id + " was not found"));

        if (request.email() != null && !request.email().isBlank()) {
            supplier.setEmail(request.email());
        }
        if (request.address() != null && !request.address().isEmpty()) {
            supplier.setAddress(request.address());
        }
        return supplierMapper.SupplierToSupplierResponse(supplierRepository.save(supplier));
    }

    public void deleteSupplier(Long id) {
        supplierRepository.findById(id)
                .orElseThrow(()-> new SupplierNotFoundException("Supplier with id: " + id + " was not found"));
        supplierRepository.deleteById(id);
    }
}
