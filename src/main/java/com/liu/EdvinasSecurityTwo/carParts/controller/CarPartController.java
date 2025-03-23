package com.liu.EdvinasSecurityTwo.carParts.controller;

import com.liu.EdvinasSecurityTwo.carParts.model.CarPart;
import com.liu.EdvinasSecurityTwo.carParts.service.CarPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
