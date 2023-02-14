package com.example.webprogr.services;

import com.example.webprogr.dto.KorisnikRegisterDto;
import com.example.webprogr.models.User;
import com.example.webprogr.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KorisnikService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public String kreirajKorisnika(KorisnikRegisterDto korisnik) throws Exception{
        var usr = this.userRepository.findByUsername(korisnik.getUsername());
        if(usr != null) throw new Exception("Korisnik sa tim emailom vec postoji!");
        User user = new User(korisnik.getUsername(),bCryptPasswordEncoder.encode(korisnik.getPassword()));
        this.userRepository.save(user);
        return "success";
    }

}
