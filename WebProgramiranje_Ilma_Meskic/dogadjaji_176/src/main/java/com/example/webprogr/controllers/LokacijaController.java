package com.example.webprogr.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.example.webprogr.models.Lokacija;
import com.example.webprogr.services.LokacijaService;

@Controller
public class LokacijaController {
	
	@Autowired
	private LokacijaService lokacijaService;
	
	@GetMapping("/lokacija")
	public String getLokacija(Model model, String keyword) {
		
        List<Lokacija> listLokacija=  lokacijaService.getLokacija();
		model.addAttribute("lokacija", listLokacija);

		if(keyword!= null){
			model.addAttribute("lokacija", lokacijaService.findByKeyword(keyword));
		}else{
			model.addAttribute("lokacija", lokacijaService.getLokacija());
		}
		
		return "lokacija";
	}

	@PostMapping("/lokacija/addNew")
	public String addNew(Lokacija lokacija){
		lokacijaService.save(lokacija);
		return "redirect:/lokacija";
	}

	@RequestMapping("lokacija/findById")
	@ResponseBody
	public Optional<Lokacija> findById(Integer id){
		return lokacijaService.findById(id);

	}

	@RequestMapping(value="/lokacija/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Lokacija lokacija){
		lokacijaService.save(lokacija);
		return "redirect:/lokacija";
	}









}
