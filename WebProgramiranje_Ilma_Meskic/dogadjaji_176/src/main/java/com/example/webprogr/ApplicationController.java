package com.example.webprogr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("/AccessPage")
	public String accessDenied(){
		return "AccessPage";
	}
	
	@GetMapping("/index")
	public String goHome() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}



}
