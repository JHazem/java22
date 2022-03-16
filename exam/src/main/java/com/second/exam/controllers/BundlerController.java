package com.second.exam.controllers;

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

import com.second.exam.models.Bundler;
import com.second.exam.models.User;
import com.second.exam.services.BundlerService;
import com.second.exam.services.UserService;
 
 
@Controller
public class BundlerController {

	@Autowired 
	private BundlerService bundlerService;
	
	@Autowired 
	private final UserService userService =null;
	

	//1
    @GetMapping("/bundlers" )
    public String indexpage(Model model,HttpSession session) {
    	
    	 // If there is no attribute "user_id" on session, then redirect to index page
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        
        // Else render the page and pass all the necessary attributes to the showsDashboarb page and return it
        else {
            User currentUser = this.userService.findById(userId);
            List<Bundler> bundlers = bundlerService.allBundlers();
            model.addAttribute("currentUser",currentUser);
            model.addAttribute("bundlers", bundlers);
            return "dashboard.jsp";
             
        }
        
    }
     
    //2
	@GetMapping("/bundlers/{bundlerId}")
	public String showBundler( Model model,
							@PathVariable("bundlerId") Long bundlerId) {
		
		Bundler bundler = bundlerService.findBundler(bundlerId);
		
		model.addAttribute("bundler",bundler);

		return "detail.jsp";
	}


	  //4.. add new Bundler       
	  @GetMapping("/bundlers/new")
	  public String newBundler(@ModelAttribute("bundler") Bundler bundler,HttpSession session, Model model) {
		  
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  model.addAttribute("thisUser",  thisUser);
	  	return "addname.jsp";
	  }
	  
	  
	//4
	//Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/bundlers/add")
	public String createNew(@Valid @ModelAttribute("bundler") Bundler bundler,
					
	  						  BindingResult result) 
	{
	  // CODE TO MAKE A NEW Bundler AND SAVE TO THE DB
	if(result.hasErrors()) {
	System.out.println("error");
	return "addname.jsp";
  	}

	bundlerService.createBundler(bundler);
	
	return "redirect:/bundlers";
	}


   //5     Edit and Update  
   // other methods removed for brevity
   @GetMapping("/bundlers/{id}/edit")
   public String edit(@PathVariable("id") Long id, Model model) {
       Bundler bundler = bundlerService.findBundler(id);
       model.addAttribute("bundler", bundler); 
       return "edit.jsp";
   }
   
   //6
   @PostMapping("/bundlers/{id}")
   public String update(@Valid @ModelAttribute("bundler") Bundler bundler, BindingResult result) {
       if (result.hasErrors()) {
    	   
           return "edit.jsp";
       } else {
    
    	   bundlerService.createBundler(bundler); 
    	   
           return "redirect:/bundlers";
       }
   }

   		//Delete
   
	 @GetMapping("/bundlers/delete/{id}")
	  public String destroy(@PathVariable("id") Long id) {
	      bundlerService.deleteBundler(id);
	      return "redirect:/bundlers";
	  }

 	 //Like
 	 @GetMapping("/vote/{id}")
 	 public String vote(@PathVariable("id") Long id,HttpSession session) {
 		 Long userId = (Long) session.getAttribute("userId");
 		 Bundler bundler =bundlerService.findBundler(id);
 		 User user = userService.findById(userId);
 		 bundlerService.vote(bundler,user);
 		 return "redirect:/bundlers"; 
 	 }
    
 	 //UnLike
 	 @GetMapping("/unvote/{id}")
 	 public String unVote(@PathVariable("id") Long id,HttpSession session) {
 		Long userId = (Long) session.getAttribute("userId");
		 Bundler bundler =bundlerService.findBundler(id);
		 User user = userService.findById(userId);
 		 bundlerService.unVote(bundler,user);
 		 return "redirect:/bundlers"; 
 	 }
	 
	 
	 
	 
}
