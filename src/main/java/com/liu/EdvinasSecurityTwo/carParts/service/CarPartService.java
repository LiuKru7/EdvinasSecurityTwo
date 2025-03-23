package com.liu.EdvinasSecurityTwo.carParts.service;

import com.liu.EdvinasSecurityTwo.carParts.model.CarPart;
import com.liu.EdvinasSecurityTwo.carParts.repository.CarPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarPartService {

    private final CarPartRepository carPartRepository;

    public List<CarPart> getAllCarParts() {
        return carPartRepository.findAll();
    }

    public CarPart addNewCarPart(CarPart carPart) {
        return carPartRepository.save(carPart);
    }
}
