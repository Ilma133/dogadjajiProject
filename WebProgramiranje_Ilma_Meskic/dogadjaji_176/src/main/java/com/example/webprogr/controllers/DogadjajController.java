package com.example.webprogr.controllers;

import java.util.List;
import java.util.Optional;

import com.example.webprogr.dto.DodajDogadjajDto;
import com.example.webprogr.models.Lokacija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.webprogr.models.Dogadjaj;
import com.example.webprogr.services.DogadjajService;

@Controller
public class DogadjajController {
	
	@Autowired
	private DogadjajService dogadjajService;
	
	@GetMapping("/dogadjaj")
	public String getDogadjaj(Model model, String keyword) {
		
		List<Dogadjaj> listDogadjaja=  dogadjajService.getDogadjaj();
		
		model.addAttribute("dogadjaj", listDogadjaja);

		if(keyword!=null){
			model.addAttribute("dogadjaj", dogadjajService.findByKeyword(keyword));
		}else{
			model.addAttribute("dogadjaj", dogadjajService.getDogadjaj());
		}
		
		return "dogadjaj";
	}


	@PostMapping("/dogadjaj/addNew")
	public String addNew(DodajDogadjajDto dogadjaj){
		dogadjajService.save(dogadjaj);
		return "redirect:/dogadjaj";
	}

	@RequestMapping("dogadjaj/findById")
	@ResponseBody
	public Optional<Dogadjaj> findById(Integer id){
		return dogadjajService.findById(id);

	}

	@RequestMapping(value="/dogadjaj/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(DodajDogadjajDto dogadjaj) throws Exception{
		dogadjajService.update(dogadjaj);
		return "redirect:/dogadjaj";
	}


}
