package com.example.webprogr.controllers;

import com.example.webprogr.dto.KorisnikRegisterDto;
import com.example.webprogr.services.KorisnikService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;
    @PostMapping("/register")
    public String kreirajKorisnika(@RequestBody KorisnikRegisterDto korisnik){
        try{
           return this.korisnikService.kreirajKorisnika(korisnik);
        }catch(Exception ex){
            return ex.getMessage();
        }
    }

}

