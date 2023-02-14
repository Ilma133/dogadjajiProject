package com.example.webprogr.services;

import com.example.webprogr.models.Kategorija;
import com.example.webprogr.models.Lokacija;
import com.example.webprogr.repositories.KategorijaRepository;
import com.example.webprogr.repositories.LokacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KategorijaService {

    @Autowired
    private KategorijaRepository kategorijaRepository;

    public List<Kategorija> getKategorija(){
        return kategorijaRepository.findAll();
    }

    public void save(Kategorija kategorija){
        kategorijaRepository.save(kategorija);
    }

    public Optional<Kategorija> findById(Integer id){
        return kategorijaRepository.findById(id);
    }

    public List<Kategorija> findByKeyword(String keyword){
        return kategorijaRepository.findByKeyword(keyword);
    }

}
