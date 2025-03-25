package com.liu.EdvinasSecurityTwo.exceptions.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record ErrorResponse(
        Timestamp timestamp,
        String message,
        Integer status
) {
}
