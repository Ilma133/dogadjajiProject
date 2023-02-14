package com.example.webprogr.controllers;

import com.example.webprogr.models.Kategorija;
import com.example.webprogr.models.Lokacija;
import com.example.webprogr.services.KategorijaService;
import com.example.webprogr.services.LokacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class KategorijaController {

	@Autowired
	private KategorijaService kategorijaService;

	@GetMapping("/kategorija")
	public String getKategorija(Model model, String keyword) {

		List<Kategorija> listKategorija=  kategorijaService.getKategorija();
		model.addAttribute("kategorija", listKategorija);

		if(keyword!= null){
			model.addAttribute("kategorija", kategorijaService.findByKeyword(keyword));
		}else{
			model.addAttribute("kategorija", kategorijaService.getKategorija());
		}


		return "kategorija";
	}

	@PostMapping("/kategorija/addNew")
	public String addNew(Kategorija kategorija){
		kategorijaService.save(kategorija);
		return "redirect:/kategorija";
	}

	@RequestMapping("kategorija/findById")
	@ResponseBody
	public Optional<Kategorija> findById(Integer id){
		return kategorijaService.findById(id);

	}

	@RequestMapping(value="/kategorija/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String update(Kategorija kategorija){
		kategorijaService.save(kategorija);
		return "redirect:/kategorija";
	}

}
