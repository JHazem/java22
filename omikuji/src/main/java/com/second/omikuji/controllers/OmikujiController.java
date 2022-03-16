package com.second.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	@GetMapping("/")
	public String index() {	
		return "index.jsp";
	}

	@GetMapping("/omikuji")
	public String omikuji() {
		return "redirect:/";
	}

	@GetMapping("/omikuji/show")
	public String show(HttpSession session,Model model) {
		
			String message = (String)  session.getAttribute("messageOmikuji");
			model.addAttribute("message", message);
			
			return "show.jsp";
	}
	
	@PostMapping("/processFormData")
	public String process(
			@RequestParam("number") int number,
			@RequestParam("cityName")String cityName,
			@RequestParam("personName") String personName,
			@RequestParam("endeavor")String endeavor,
			@RequestParam("living") String living,
			@RequestParam("message")String message,
			HttpSession session) {
		String messageOmikuji= "In 10 years, you will live in Nairobi with Bob Dylan as your roommate, selling ...";
		session.setAttribute("messageOmikuji", messageOmikuji);
		
		return "redirect:/omikuji/show";
	}
}
