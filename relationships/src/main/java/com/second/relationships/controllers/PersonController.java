package com.second.relationships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.second.relationships.models.Person;
import com.second.relationships.services.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService; 
	
    @RequestMapping("/persons")
    public String index(@ModelAttribute("addNew") Person language, Model model) {
    	
            List<Person> persons = personService.allPerson();
            
            model.addAttribute("persons", persons);
            return "index.jsp";
    }
    
	@GetMapping("/languages/{id}")
	public String showPerson( Model model,
							@PathVariable("id") Long id) {
		
		Person person = personService.findPerson(id);
		
		model.addAttribute("person",person);

		return "show.jsp";
	}
	
    
    
    
	
}
