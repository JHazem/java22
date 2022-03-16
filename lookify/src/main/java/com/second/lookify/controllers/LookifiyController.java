package com.second.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.second.lookify.LookifyService.LookifyService;
import com.second.lookify.models.Lookify;

@Controller
public class LookifiyController {

	@Autowired
	private LookifyService lookifyService;
	
	@RequestMapping("/")
	public String index() {
		return "dashboard.jsp";
	}
	
	//1
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lookify> lookifies = lookifyService.allLookify();
		model.addAttribute("lookifies", lookifies);
		return "dashboard.jsp";
	}
	
	//2
	@GetMapping("/lookifies/{id}")
	public String showLookify( Model model,
							@PathVariable("id") Long id){
		Lookify lookify = lookifyService.findLookify(id);
		model.addAttribute("lookify", lookify);
		return "song.jsp";
  	}
		

	//4 
	@RequestMapping("/Lookifies/new")
	  public String createNew(@Valid @ModelAttribute("lookify") Lookify lookify,
				  BindingResult result){						
	  	if(result.hasErrors()) {
	  		return "new.jsp";
	  	}
	  	
	  	lookifyService.createLookify(lookify);
	    
	    return "redirect:/lookifies";
	  }						
	
	  //5  
	   @GetMapping("/lookifies/toptensong/{id}")
	   public String topten(@PathVariable("id") Long id, Model model) {
		   Lookify lookify =lookifyService.findLookify(id);
		   model.addAttribute("lookify" , lookify);
		   return "song.jsp";
	   }
	  
	   //6  
	   @PutMapping("/lookifies/{id}")
	   public String update(@Valid @ModelAttribute("lookify") Lookify lookify , BindingResult result){
		   if(result.hasErrors()) {
			   return "dashboard.jsp";
		   }else {
			   lookifyService.updateLookify(lookify);
			   return "new.jsp";
		   }
	   }
	
	   //7 delete
       @DeleteMapping("/delete/{id}")	
       public String destroy(@PathVariable("id") Long id) {
    	   lookifyService.deleteLookify(id);
    	   return "redirect:/dashboard";
       }

	
       //8
       @PostMapping("/search")
       public String search(@RequestParam("artist") String artist) {
    	   return "redirect:/search" +artist;
    	   
       }
	


	
	
}
