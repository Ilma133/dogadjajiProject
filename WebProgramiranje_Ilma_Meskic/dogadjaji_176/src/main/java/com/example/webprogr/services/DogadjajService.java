/*package com.example.webprogr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webprogr.repositories.DogadjajRepository;
import com.example.webprogr.models.Dogadjaj;

import antlr.collections.List;

@Service
public class DogadjajService {
	
	@Autowired
	
	private DogadjajRepository dogadjajRepository;
	public List getDogadjaj(){
		return (List) dogadjajRepository.findAll();
	}

}*/

package com.example.webprogr.services;

import com.example.webprogr.dto.DodajDogadjajDto;
import com.example.webprogr.models.Lokacija;
import com.example.webprogr.repositories.KategorijaRepository;
import com.example.webprogr.repositories.LokacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webprogr.repositories.DogadjajRepository;
import com.example.webprogr.models.Dogadjaj;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DogadjajService {
	
	@Autowired
	
	private DogadjajRepository dogadjajRepository;
	@Autowired
	private LokacijaRepository lokacijaRepository;
	@Autowired
	private KategorijaRepository kategorijaRepository;
	public List<Dogadjaj> getDogadjaj(){

		LocalDate today = LocalDate.now();

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formattedDate = today.format(dateTimeFormatter);
		List<Dogadjaj> dogadjaji;
		dogadjaji=dogadjajRepository.findAll();
		dogadjaji=dogadjaji.stream().filter(dogadjaj -> dogadjaj.getDatum().compareTo(formattedDate)>=0).collect(Collectors.toList());
		//dogadjaji=dogadjaji.stream().filter(dogadjaj -> dogadjaj.getDatum().compareTo(String.valueOf(LocalDate.now()))>=0).collect(Collectors.toList());
		return dogadjaji;
		//return  dogadjajRepository.findAll();
		//return dogadjajRepository.findAll().stream().filter(dogadjaj -> dogadjaj.getDatum().compareTo(String.valueOf(LocalDate.now()))>=0).collect(Collectors.toList());
	}

	public void save(DodajDogadjajDto dogadjaj){
		var lokacija = this.lokacijaRepository.findByName(dogadjaj.getLokacijaname());
		var kategorija = this.kategorijaRepository.findByName(dogadjaj.getKategorijaname());
		var dogad = new Dogadjaj();
		dogad.setKategorija(kategorija);
		dogad.setLokacija(lokacija);
		dogad.setDogadjajname(dogadjaj.getDogadjajname());
		dogad.setPhotoURL(dogadjaj.getPhotoURL());
		dogad.setDatum(dogadjaj.getDatum());
		dogad.setDescription(dogadjaj.getDescription());
		dogadjajRepository.save(dogad);
	}
	public void update(DodajDogadjajDto dogadjaj) throws Exception{
		var item = this.dogadjajRepository.findById(dogadjaj.getId().get()).get();
		if(item==null) throw new Exception("Dogadjaj ne postoji");
		item.setDogadjajname(dogadjaj.getDogadjajname());
		item.setDescription(dogadjaj.getDescription());
		item.setPhotoURL(dogadjaj.getPhotoURL());
		item.setDatum(dogadjaj.getDatum());
		var lokacija = this.lokacijaRepository.findByName(dogadjaj.getLokacijaname());
		var kat = this.kategorijaRepository.findByName(dogadjaj.getKategorijaname());
		item.setKategorija(kat);
		item.setLokacija(lokacija);
		this.dogadjajRepository.save(item);
	}

	public Optional<Dogadjaj> findById (Integer id){
		return dogadjajRepository.findById(id);
	}

	public List<Dogadjaj> findByKeyword(String keyword){
		return dogadjajRepository.findByKeyword(keyword);
	}



}


