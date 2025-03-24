package com.liu.EdvinasSecurityTwo.carParts.service;

import com.liu.EdvinasSecurityTwo.carParts.dto.SupplierRequest;
import com.liu.EdvinasSecurityTwo.carParts.dto.SupplierResponse;
import com.liu.EdvinasSecurityTwo.carParts.mapper.SupplierMapper;
import com.liu.EdvinasSecurityTwo.carParts.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
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
        return null;
    }

    public String updateSupplier(SupplierRequest request, Long id) {
        return "String";
    }

    public Object deleteSupplier(Long id) {
        return null;
    }
}
