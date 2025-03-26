package com.liu.EdvinasSecurityTwo.carParts.mapper;

import com.liu.EdvinasSecurityTwo.carParts.dto.CarPartResponse;
import com.liu.EdvinasSecurityTwo.carParts.model.CarPart;
import org.springframework.stereotype.Service;

@Service
public class CarPartMapper {

    public CarPartResponse toCarPartResponse(CarPart carPart) {
        return  new CarPartResponse(carPart.getName(), carPart.getStock(), carPart.getDescription());
    }
}
