package com.example.webprogr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webprogr.models.Lokacija;
import com.example.webprogr.repositories.LokacijaRepository;

@Service
public class LokacijaService {
	
@Autowired
private LokacijaRepository lokacijaRepository;

	public List<Lokacija> getLokacija(){
		return lokacijaRepository.findAll();
	}

	public void save(Lokacija lokacija){
		lokacijaRepository.save(lokacija);
	}

	public Optional<Lokacija> findById(Integer id){
		return lokacijaRepository.findById(id);
	}

	public List<Lokacija> findByKeyword(String keyword){
		return lokacijaRepository.findByKeyword(keyword);
	}



}
