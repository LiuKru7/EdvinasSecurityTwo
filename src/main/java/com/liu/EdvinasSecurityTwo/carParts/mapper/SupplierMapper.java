package com.liu.EdvinasSecurityTwo.carParts.mapper;

import com.liu.EdvinasSecurityTwo.carParts.dto.SupplierRequest;
import com.liu.EdvinasSecurityTwo.carParts.dto.SupplierResponse;
import com.liu.EdvinasSecurityTwo.carParts.model.Supplier;
import org.springframework.stereotype.Service;

@Service
public class SupplierMapper {

    public SupplierResponse SupplierToSupplierResponse (Supplier supplier) {
        return new SupplierResponse(supplier.getId(), supplier.getAddress(), supplier.getEmail());
    }
    public Supplier SupplierRequestToSupplier(SupplierRequest request) {
        return Supplier.builder()
                .address(request.address())
                .email(request.email())
                .build();
    }
}
