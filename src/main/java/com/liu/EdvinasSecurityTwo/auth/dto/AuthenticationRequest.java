package com.liu.EdvinasSecurityTwo.auth.dto;

public record AuthenticationRequest(
        String username,
        String password
) {
}
