package com.second.testexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.second.testexam.models.LoginUser;
import com.second.testexam.models.User;
import com.second.testexam.services.UserService;
import com.second.testexam.validator.UserValidator;

@Controller
public class UserController {
 
	 // Add once service is implemented:
	  @Autowired
	  private UserService userService;
	 
	  @Autowired
	  private UserValidator userValidator;
	  
	  //p
	  @GetMapping("/")
	  public String getRegistration(@ModelAttribute("user") User user,Model model ){
		     model.addAttribute("user", new User());
			 model.addAttribute("newLogin", new LoginUser());
		       
		   return "index.jsp";
  }

	  //p/2
  	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user,
									BindingResult result,
									HttpSession session,
									RedirectAttributes redirectAttributes) {
		  
		    				//match211  result
	   	userValidator.validate(user, result);
	   	
	 	if(result.hasErrors()) {
 		return "index.jsp";
	 		
	 	}else {
	 		
	 		User newUser = userService.registerUser(user, result);
	 		session.setAttribute("userId", newUser.getId());
	 		redirectAttributes.addFlashAttribute("message","Thank you for registration!");
	 		return "redirect:/babyNames";
	 	}
 	}
 
		 
	  // Login 

	  
	 @PostMapping("/login")
	 public String loginUser(@RequestParam("email") String email,
			 				@RequestParam("password") String password,
			 				HttpSession session,
			 				RedirectAttributes redirectAttributes) {
	     
   
     if(userService.authenticateUser(email, password)) {

    	 User user = userService.findByEmail(email);
    	 session.setAttribute("userId",user.getId());
         return "redirect:/babyNames";
     }
     else {									//"error" is a key for valid login in index.jsp file		
		 redirectAttributes.addFlashAttribute("error","Invalid user password");
		 return "redirect:/";
	 }			  
	  
	 }
	 

	 
	 // Logout
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 
	 }	 
	 
	 // Project Dashboard
	 @GetMapping("/dashboard")
	 public String projects(Model model,HttpSession session) {
		 if(session.getAttribute("userId") !=null) {
			 User user = userService.findById((Long) session.getAttribute("userId"));
			 model.addAttribute("user" , user);
			 return "dashboard.jsp";
		 }else {
			 return "redirect:/registration";
		 }
	 }
}

