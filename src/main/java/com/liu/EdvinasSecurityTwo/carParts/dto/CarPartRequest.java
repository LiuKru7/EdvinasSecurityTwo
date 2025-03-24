package com.liu.EdvinasSecurityTwo.carParts.dto;

import com.liu.EdvinasSecurityTwo.carParts.model.CarPart;

public record CarPartRequest(
        CarPart carPart,
        Long supplierId
) {
}
