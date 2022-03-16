package com.second.tvshows.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.second.tvshows.models.TvShow;
import com.second.tvshows.models.User;
import com.second.tvshows.services.TvShowService;
import com.second.tvshows.services.UserService;
 
@Controller
public class TvController {

	@Autowired 
	private TvShowService tvService;
	
	@Autowired 
	private final UserService userService =null;
	

	//1
    @GetMapping("/tvshows" )
    public String indexpage(Model model,HttpSession session) {
    	
    	 // If there is no attribute "user_id" on session, then redirect to index page
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        
        // Else render the page and pass all the necessary attributes to the showsDashboarb page and return it
        else {
            User currentUser = this.userService.findById(userId);
            List<TvShow> tvshows = tvService.allTvShows();
            
            model.addAttribute("user",currentUser);
            
            model.addAttribute("tvshows", tvshows);
            
            return "dashboard.jsp";
             
        }
        
    }
     
    //2
	@GetMapping("/tvshows/{tvId}")
	public String showTv( Model model,
							@PathVariable("tvId") Long tvId) {
		
		TvShow tvshow = tvService.findTv(tvId);
		
		model.addAttribute("tvshow",tvshow);

		return "detail.jsp";
	}


	  //4.. add new tv       
	  @GetMapping("/tvshows/new")
	  public String newTv(@ModelAttribute("tvshow") TvShow tvshow,HttpSession session, Model model) {
		  
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  model.addAttribute("thisUser",  thisUser);
	  	return "addshow.jsp";
	  }
	  
	  
	//4
	//Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/tvshows")
	public String createNew(@Valid @ModelAttribute("tvshow") TvShow tvshow,
					
	  						  BindingResult result) { 
	if(result.hasErrors()) {
	
		return "addshow.jsp";
  	}

	tvService.createTvShow(tvshow);
	
	return "redirect:/tvshows";
	}


   //5     Edit and Update  
   // other methods removed for brevity
   @GetMapping("/tvshows/{id}/edit")
   public String edit(@PathVariable("id") Long id, Model model) {
       TvShow tvshow = tvService.findTv(id);
       model.addAttribute("tvshow", tvshow);
       
	   System.out.println("GET");
	     
       return "edit.jsp";
   }
   
   //6
   @PutMapping("/tvshows/{id}")
   public String update(@Valid @ModelAttribute("tvshow") TvShow tvshow, BindingResult result) {
       if (result.hasErrors()) {
           return "edit.jsp";
       } else {
    	   System.out.println("PUT"); 
    	   tvService.createTvShow(tvshow); 
           return "redirect:/tvshows";
       }
   }

   		//Delete
   
	 @GetMapping("/tvshows/delete/{id}")
	  public String destroy(@PathVariable("id") Long id) {
	      tvService.deleteTvShow(id);
	      return "redirect:/tvshows";
	  }
 

   
   
}
