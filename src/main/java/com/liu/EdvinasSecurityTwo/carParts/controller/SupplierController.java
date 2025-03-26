package com.liu.EdvinasSecurityTwo.carParts.controller;

import com.liu.EdvinasSecurityTwo.carParts.dto.SupplierRequest;
import com.liu.EdvinasSecurityTwo.carParts.dto.SupplierResponse;
import com.liu.EdvinasSecurityTwo.carParts.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier/admin")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAllSupplier() {
        return ResponseEntity.ok(supplierService.getAllSupplier());
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> addSupplier(@RequestBody SupplierRequest request) {
        return ResponseEntity.ok(supplierService.addSupplier(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> updateSupplier(
            @RequestBody SupplierRequest request,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(supplierService.updateSupplier(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.accepted().build();
    }
}
