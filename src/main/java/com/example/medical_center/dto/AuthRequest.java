package com.example.medical_center.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
