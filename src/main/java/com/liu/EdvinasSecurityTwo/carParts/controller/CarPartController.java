package com.liu.EdvinasSecurityTwo.carParts.controller;

import com.liu.EdvinasSecurityTwo.carParts.dto.CarPartRequest;
import com.liu.EdvinasSecurityTwo.carParts.dto.CarPartResponse;
import com.liu.EdvinasSecurityTwo.carParts.model.CarPart;
import com.liu.EdvinasSecurityTwo.carParts.service.CarPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carparts")
@RequiredArgsConstructor
public class CarPartController {

    private final CarPartService carPartService;

    @GetMapping("/user")
    public ResponseEntity<List<CarPart>> getAllCarParts() {
        return ResponseEntity.ok(carPartService.getAllCarParts());
    }

    @PostMapping("/admin")
    public ResponseEntity<?> addNewCarPart(@RequestBody CarPartRequest request)  {
        carPartService.addNewCarPart(request);
        return ResponseEntity.ok(request.carPart());
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<CarPartResponse> updateCarPart(@RequestBody CarPartRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(carPartService.updateCarPart(request,id));

    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteCarPartById(@PathVariable Long id) {
        carPartService.deleteCarPartById(id);
        return ResponseEntity.accepted().build();
    }

}
