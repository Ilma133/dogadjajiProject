package com.example.webprogr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class DodajDogadjajDto {
    private Optional<Integer> id;
    private String dogadjajname;
    private String datum;
    private String description;
    private String photoURL;
    private String lokacijaname;
    private String kategorijaname;
}
