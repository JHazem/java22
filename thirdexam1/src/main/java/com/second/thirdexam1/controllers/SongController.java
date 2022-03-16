package com.second.thirdexam1.controllers;

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

import com.second.thirdexam1.models.Song;
import com.second.thirdexam1.models.User;
import com.second.thirdexam1.services.SongService;
import com.second.thirdexam1.services.UserService;

@Controller
public class SongController {

	@Autowired 
	private SongService songService;
	
	@Autowired 
	private final UserService userService =null;
	
	//1
    @GetMapping("/songs" )
    public String indexpage(Model model,HttpSession session) {
    	
    	 // If there is no attribute "user_id" on session, then redirect to index page
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        
        // Else render the page and pass all the necessary attributes to the showsDashboarb page and return it
        else {
            User currentUser = this.userService.findById(userId);
            List<Song> songs = songService.allSongs();
            model.addAttribute("currentUser",currentUser);
            model.addAttribute("songs", songs);
            return "dashboard.jsp";
             
        }
        
    }
	
    //2
	@GetMapping("/songs/{songId}")
	public String showSong( Model model,
							@PathVariable("songId") Long songId) {
		
		Song song = songService.findSong(songId);
		
		model.addAttribute("song",song);

		return "detail.jsp";
	}


	  //4.. add new song       
	  @GetMapping("/songs/new")
	  public String newSong(@ModelAttribute("song") Song song,HttpSession session, Model model) {
		  
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  model.addAttribute("thisUser",  thisUser);
	  	return "addname.jsp";
	  }
	  
	//4
		//Note: We'll be altering this a bit after we introduce data binding.
		@PostMapping("/songs/add")
		public String createNew(@Valid @ModelAttribute("song") Song song,
						
		  						  BindingResult result) 
		{
		  // CODE TO MAKE A NEW song AND SAVE TO THE DB
		if(result.hasErrors()) {
		System.out.println("error");
		return "addname.jsp";
	  	}

		songService.createSong(song);
		
		return "redirect:/songs";
		}


	   //5     Edit and Update  
	   // other methods removed for brevity
	   @GetMapping("/songs/{id}/edit")
	   public String edit(@PathVariable("id") Long id, Model model) {
	       Song song = songService.findSong(id);
	       
	       model.addAttribute("song", song); 
	       return "edit.jsp";
	   }
	
    
	   //6
	   @PostMapping("/songs/{id}")
	   public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
	       if (result.hasErrors()) {
	    	   
	           return "edit.jsp";
	       } else {
	    
	    	   song.setColl(song.getColl().intValue()+1);
	    	   songService.updateSong(song); 
	           return "redirect:/songs";
	       }
	   }

	   		//Delete
	   
		 @GetMapping("/songs/delete/{id}")
		  public String destroy(@PathVariable("id") Long id) {
		      songService.deleteSong(id);
		      return "redirect:/songs";
		  }
    
    

	
		 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
	
}
