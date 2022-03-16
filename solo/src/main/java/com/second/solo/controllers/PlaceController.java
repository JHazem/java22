package com.second.solo.controllers;
 

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import com.second.solo.models.Place;
import com.second.solo.models.Story;
import com.second.solo.models.User;
import com.second.solo.services.PlaceService;
import com.second.solo.services.StoryService;
import com.second.solo.services.UserService;

@Controller
public class PlaceController {


	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private StoryService storyService;
	
	@Autowired
	private final UserService userService= null;
	

 	
	//1
    @GetMapping("/places" )
    public String placepage(Model model,HttpSession session) {
    	
	    Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/";
	    }
	     else {
	        User currentUser = this.userService.findById(userId); 					
	        
 	         List<Place>  places = placeService.allPlaces();  //Search  
 	         model.addAttribute("myPlace", places);
 	         if(session.getAttribute("city") !=null) {     
 	        	  String keyword = (String)session.getAttribute("city");   
	        	  model.addAttribute("places",placeService.findUserPlace(keyword)); 
	        	  session.removeAttribute("city");     // to appear the table contain 
 	         }else {          
 	        	model.addAttribute("places", placeService.allPlaces());   //Search 
 	         }
 	          
 	         model.addAttribute("user",currentUser); 
	        return "placetable.jsp";
	    }
        
    }
	
     
    //2
    @GetMapping("/places/{placeId}")
	public String nPlace( Model model,
							@PathVariable("placeId") Long placeId) {
		
		Place place = placeService.findPlace(placeId); 
		model.addAttribute("place",place);
		model.addAttribute("stories", place.getStories()); // to get all stories in specific city
		
		System.out.println(place.getStories());
		return "detailplace.jsp";
	}
	
    
    //4 .. add new place
	@GetMapping("/places/new")
	public String newPlace(@ModelAttribute("addNewPlace") Place place,HttpSession session,Model model) {
 		List<Story> storiesList = storyService.allStories();
		
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  model.addAttribute("stories", storiesList);
		  model.addAttribute("thisUser",  thisUser);
		return "addplace.jsp";
	}
  		
	
	//4  CODE TO MAKE A NEW user AND SAVE TO THE DB  1
	@PostMapping("/places")
	public String addPlace(@Valid @ModelAttribute("addNewPlace") Place place,
							 	BindingResult result) {
		if(result.hasErrors()) { 
			return "addplace.jsp";
		}
		else {
	 
			placeService.creatPlace(place); 
			return "redirect:/places";
			}
		}
		
		//5 edit
		@GetMapping("/places/{id}/edit")
		   public String editPlace(@PathVariable("id") Long id, Model model) {
		       Place place = placeService.findPlace(id);
		       model.addAttribute("place", place);
		       //System.out.println(place.getUser().getId());
		       return "editplace.jsp";
		   }
		
	
		//6
		@PostMapping("/places/{id}")
		   public String updatePlace(@Valid @ModelAttribute("place") Place place, BindingResult result) {
		       if (result.hasErrors()) {
		           return "editplace.jsp";
		       } else { 
		           placeService.savePlace(place);
		           return "redirect:/places";
		       }
		   }
		
		
		//delete
		@GetMapping("/places/delete/{id}")
		  public String destroyPlace(@PathVariable("id") Long id) {
			placeService.deletePlace(id);
		      return "redirect:/places";
		  }
		
 
		
		//Search 
		@PostMapping("/user/place_search")
		public String placeSearch(Model model,HttpSession session, @RequestParam("freeText") String freeText) {
			  
			if(freeText == "") {
				return "redirect:/places";
				
			
			}
			session.setAttribute("city", freeText);
			return "redirect:/places";
		}
	
		
		
}
