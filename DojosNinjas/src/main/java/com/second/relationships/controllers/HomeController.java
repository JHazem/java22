package com.second.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.second.relationships.models.Dojo;
import com.second.relationships.models.Ninja;
import com.second.relationships.services.DojoNinjaService;

@Controller
public class HomeController {

	//p
	@Autowired
	private DojoNinjaService dojoNinjaService;
	

	//1  dojo p
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("addNewDojo") Dojo dojo) {
		
		return "newdojo.jsp";
	}
	 
	//2  CODE TO MAKE A NEW dojo AND SAVE TO THE DB
	@PostMapping("/newdojo1")
	public String addDojo(@Valid @ModelAttribute("addNewDojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp";
		}
		else {
			dojoNinjaService.saveDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	//3    p/2
	@GetMapping("/dojos/{id}")
	public String Dojo( Model model,
						@PathVariable("id") Long id) {
		Dojo dojo = dojoNinjaService.findDojo(id);
		
		model.addAttribute("dojo", dojo);
			
		return "show.jsp";
	}
	
	 
	//1  ninja p
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("addNewNinja") Ninja ninja,Model model) {
		model.addAttribute("dojos", dojoNinjaService.getAllDojos());
		return "newninja.jsp";
	}
	
	//2 CODE TO MAKE A NEW ninja AND SAVE TO THE DB
	@PostMapping("/addninja")
	public String addNinja( @Valid @ModelAttribute("addNewNinja") Ninja ninja,
							Long id, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "newninja.jsp";
		}
		else {
			Ninja newNinja = dojoNinjaService.saveNinja(ninja);
			model.addAttribute("newNinja", newNinja); 
			Dojo dojo= ninja.getDojo();
			Long dojoId=dojo.getId();
			return "redirect:/dojos/"+ dojoId; 
		}
	}
	

	
}
