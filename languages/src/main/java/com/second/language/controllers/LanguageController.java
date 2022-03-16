package com.second.language.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.second.language.models.Language;
import com.second.language.servises.LanguageService;

@Controller
public class LanguageController {
	//p
	@Autowired
	private LanguageService languageService;
	
   //1  p
    @RequestMapping("/languages")
    public String index(@ModelAttribute("addNew") Language language, Model model) {
    	
            List<Language> languages = languageService.allLanguages();
            
            model.addAttribute("languages", languages);
            return "index.jsp";
    }
    
    //2    p/2 
	@GetMapping("/languages/{id}")
	public String showLanguage( Model model,
							@PathVariable("id") Long id) {
		
		Language language = languageService.findLanguage(id);
		
		model.addAttribute("language",language);

		return "show.jsp";
	}
	
	@GetMapping("/languages/new")
	public String newLanguage(@ModelAttribute("language") Language language) {
		return "new.jsp";
	}
	
		//4  CODE TO MAKE A NEW Language AND SAVE TO THE DB
	  @PostMapping("/languages/new")
	  public String createNew(@Valid @ModelAttribute("language") Language language,
	  						  BindingResult result) 
	  { 
	  	if(result.hasErrors()) {
	  		return "redirect:/languages";
	  	}
	  	
	  	languageService.createLanguage(language);
	    
	    return "redirect:/languages";
	  }

	  //5  edit
	   @GetMapping("/languages/edit/{id}")
	   public String edit(@PathVariable("id") Long id, Model model) {
		   Language language = languageService.findLanguage(id);
	       model.addAttribute("language", language);
	       return "edit.jsp";
	   } 
	   
	   //6
	   @PutMapping("/languages/{id}")
	   public String update(@Valid @ModelAttribute("language") Language language,
			   				BindingResult result) {
	 
		   if (result.hasErrors()) {
	           return "/edit.jsp";
	       } else {
	    	   languageService.updateLanguage(language);
	           return "redirect:/languages";
	       }
	   }
	   
	   //7
	   //delete
       @GetMapping("/languages/delete/{id}")
       public String destroy(@PathVariable("id") Long id) {
    	   languageService.deleteLanguage(id);
           return "redirect:/languages";
       }

       
	   //details
       @GetMapping("/languages/details/{id}")
       public String details(@PathVariable("id") Long id, Model model) {
    	   model.addAttribute("language", languageService.findLanguage(id));
           return "redirect:/languages";
       }

	   }






















