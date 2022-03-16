package com.second.testexam.controllers;

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

import com.second.testexam.models.BabyName;
import com.second.testexam.models.User;
import com.second.testexam.services.BabyNameService;
import com.second.testexam.services.UserService;

@Controller
public class BabyNameController {

	@Autowired 
	private BabyNameService babyNameService;
	
	@Autowired 
	private final UserService userService =null;
	

	//1
   @GetMapping("/babyNames" )
   public String indexpage(Model model,HttpSession session) {
   	
   	 // If there is no attribute "user_id" on session, then redirect to index page
       Long userId = (Long) session.getAttribute("userId");
       if (userId == null) {
           return "redirect:/";
       }
       
       // Else render the page and pass all the necessary attributes to the showsDashboarb page and return it
       else {
           User currentUser = this.userService.findById(userId);
           List<BabyName> babyNames = babyNameService.allBabyNames();
           model.addAttribute("currentUser",currentUser);
           model.addAttribute("babyNames", babyNames);
           return "dashboard.jsp";
            
       }
       
   }
    
   //2
	@GetMapping("/babyNames/{babyNameId}")
	public String showBabyName( Model model,
							@PathVariable("babyNameId") Long babyNameId) {
		
		BabyName babyName= babyNameService.findBabyName(babyNameId);
		
		model.addAttribute("babyName",babyName);

		return "detail.jsp";
	}


	  //4.. add new BabyName       
	  @GetMapping("/babyNames/new")
	  public String newBabyName(@ModelAttribute("baby") BabyName babyName,HttpSession session, Model model) {
		  
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  model.addAttribute("thisUser",  thisUser);
	  	return "addname.jsp";
	  }
	  
	  
	//4
	//Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/babyNames/add")
	public String createNew(@Valid @ModelAttribute("baby") BabyName babyName,
					
	  						  BindingResult result) 
	{
	  // CODE TO MAKE A NEW BanyName AND SAVE TO THE DB
	if(result.hasErrors()) {
	System.out.println("error");
	return "addname.jsp";
 	}

	babyNameService.createBabyName(babyName);
	
	return "redirect:/babyNames";
	}


  //5     Edit and Update  
  // other methods removed for brevity
  @GetMapping("/babyNames/{id}/edit")
  public String edit(@PathVariable("id") Long id, Model model) {
      BabyName babyName= babyNameService.findBabyName(id);
      model.addAttribute("babyName", babyName); 
      return "edit.jsp";
  }
  
  //6
  @PostMapping("/babyNames/{id}")
  public String update(@Valid @ModelAttribute("babyName") BabyName babyName,
		  							BindingResult result) {
      if (result.hasErrors()) {
   	   
          return "edit.jsp";
      } else {
   
   	   babyNameService.createBabyName(babyName); 
   	   
          return "redirect:/babyNames";
      }
  }

  		//Delete
  
	 @GetMapping("/babyNames/delete/{id}")
	  public String destroy(@PathVariable("id") Long id) {
	      babyNameService.deleteBabyName(id);
	      return "redirect:/babyNames";
	  }

	 //Like
	 @GetMapping("/vote/{id}")
	 public String vote(@PathVariable("id") Long id,HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
		 BabyName babyName =babyNameService.findBabyName(id);
		 User user = userService.findById(userId);
		 babyNameService.vote(babyName,user);
		 return "redirect:/babyNames"; 
	 }
   
	 //UnLike
	 @GetMapping("/unvote/{id}")
	 public String unVote(@PathVariable("id") Long id,HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		 BabyName babyName =babyNameService.findBabyName(id);
		 User user = userService.findById(userId);
		 babyNameService.unVote(babyName,user);
		 return "redirect:/babyNames"; 
	 }
	 
	 
	 
	 
}
