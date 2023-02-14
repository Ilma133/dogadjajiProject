package com.example.webprogr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KorisnikRegisterDto {
    private String username;
    private String password;
}
