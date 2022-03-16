package com.second.relationships.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.second.relationships.models.LoginUser;
import com.second.relationships.models.User;
import com.second.relationships.services.UserService;
import com.second.relationships.validation.UserValidator;


@Controller
public class UserController {
 
	 // Add once service is implemented:
	  @Autowired
	  private UserService userServ;
	 
	  @Autowired
	  private UserValidator userValidator;
	  
	  @GetMapping("/")
	  public String index(@ModelAttribute("newUser") User user){
		  return "index.jsp";
		  
	  }
	  
	  
	 @GetMapping("/register")
	public String registerUser(Model model, @ModelAttribute("newUser") User newUser,
			BindingResult result) {
		 // Match1
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     								//match211  result
	     userValidator.validate(newUser, result);
		 return "index.jsp";
	 
	 }
	 
	 @GetMapping("/login")
	public String loginUser() {
		 return "projects.jsp";
	 
	 }
	 
	 // Register a user
	// match11 key "register" 
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
			 				BindingResult result, 
			 				HttpSession session, Model model,
			 				RedirectAttributes redirectAttributes) { 
	     
	     if(result.hasErrors()) {
	         model.addAttribute("newLogin", new LoginUser());
	         return "index.jsp";
	     }
	     
	     // No errors! 
	     
	     User user = userServ.register(newUser, result);
	     
	     session.setAttribute("newUserId", user.getId());
	     return "redirect:/projects";
	 	}
 
	 // Login
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
			 				String email,
			 				BindingResult result, Model model,
			 				HttpSession session,
			 				RedirectAttributes redirectAttributes) {
	     
   
     if(result.hasErrors()) {
    	 User user = userServ.findByEmail(email);
    	 session.setAttribute("newUserId",user.getId());
         model.addAttribute("newUser", new User());
         return "redirect:/projects";
     }
   
		 else {									//"error" is a key for valid login in index.jsp file		
			 redirectAttributes.addFlashAttribute("error","Invalid user pass");
			 return "redirect:/";
		 }
	 }
		 
	 // Logout
	 @GetMapping("/logout")
	public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 
	 }
	 

	 
	 
	}
	
	
	
