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

import com.second.solo.models.Comment;
import com.second.solo.models.Place;
import com.second.solo.models.Story;
import com.second.solo.models.User;
import com.second.solo.services.PlaceService;
import com.second.solo.services.StoryService;
import com.second.solo.services.UserService;

@Controller
public class StoryController {

	
	@Autowired
	private StoryService storyService;
	
	@Autowired
	private PlaceService placeService;
	
	
	@Autowired
	private final UserService userService= null;
	 
	
	//1
    @GetMapping("/stories" )
    public String storypage(Model model,HttpSession session) {
    	
	    Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/";
	    }
	     else {
	        User currentUser = this.userService.findById(userId); 			
	        
	        List<Story> joinStories = storyService.allStories(); // to appear the table contain 
	        model.addAttribute("myStories", joinStories);   
	        
	        // - - - - - - - - Search
	        if(session.getAttribute("title") !=null) {   //Search 
	        	 String keyword = (String)session.getAttribute("title");   //Search 
	        	  model.addAttribute("stories",storyService.findUserStory(userId,keyword));  //Search 
	        	  session.removeAttribute("title");// to appear the table contain 
	         }else {          
	        	model.addAttribute("stories", storyService.allStories());   //Search 
	         }
	        // - - - - - - - -
	        
	        model.addAttribute("user",currentUser);  
 		    
	        return "storytable.jsp";
	    }
        
    }
	
    //2
    @GetMapping("/stories/{storyId}")
	public String addStory (Model model,
							@PathVariable("storyId") Long storyId,
							@ModelAttribute("commentObject") Comment comment,
							HttpSession session) {
		
		Story story = storyService.findStory(storyId);
		model.addAttribute("story",story);
		
		// add session variable  
		model.addAttribute("user", session.getAttribute("userId"));
		
		return "detailstory.jsp";
	}
	 
	
   	//4 .. add new story
	@GetMapping("/stories/new")
	public String newStory(@ModelAttribute("addNewStory") Story story,HttpSession session,Model model) {
		 List<Place> joinPlaces = placeService.allPlaces();
		
		  model.addAttribute("places", joinPlaces);// for add place as a down arrow
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  
		  model.addAttribute("place", joinPlaces);
		  model.addAttribute("thisUser",  thisUser);
		return "addstory.jsp";
	}
  		
  		
	//2  CODE TO MAKE A NEW user AND SAVE TO THE DB  1
	@PostMapping("/stories")
	public String addStory(@Valid @ModelAttribute("addNewStory") Story story,
							 	BindingResult result) {
		if(result.hasErrors()) {
			return "addstory.jsp";
		}
		else {
			
			storyService.creatStory(story);
			return "redirect:/stories";
		}
	}
	
	//5 edit
	@GetMapping("/stories/{id}/edit")
	   public String editStory(@PathVariable("id") Long id, Model model) {
	       Story story = storyService.findStory(id);
	       model.addAttribute("story", story); 
	       return "editstory.jsp";
	   }
	

	//6
//	@PostMapping("/stories/{id}")
//	   public String updateStory(@Valid @ModelAttribute("story") Story story, BindingResult result) {
//	       if (result.hasErrors()) {
//	           return "editstory.jsp";
//	       } else { 
//	           storyService.saveStory(story);
//	           return "redirect:/stories";
//	       }
//	   }
	
	
	//delete
	@GetMapping("/stories/delete/{id}")
	  public String destroyStory(@PathVariable("id") Long id) {
		storyService.deleteStory(id);
	      return "redirect:/stories";
	  }
	 
	
	//Search 
	@PostMapping("/user/story_search")
	public String storySearch(Model model,HttpSession session, @RequestParam("freeText") String freeText) {
		
		if(freeText == "") {
			return "redirect:/stories";
		}
		session.setAttribute("title", freeText);
		return "redirect:/stories";
	}

	
	
}
