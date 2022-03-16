package com.second.relationships.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.second.relationships.authentication.models.User;
import com.second.relationships.authentication.services.UserService;


@Controller
public class UserController {
 
	 // Add once service is implemented:
	  @Autowired
	  private UserService userService;
	 
	  //@Autowired
	  //private UserValidator userValidator;
	  
	  @GetMapping("/")
	  public String index(@ModelAttribute("user") User user){
		  return "index.jsp";
		  
	  }
	  
		 @GetMapping("/registeration")
			public String registerUser(@Valid @ModelAttribute("user") User user,
					HttpSession session,
					BindingResult results) {
			 if(results.hasErrors()) {
				 return "index.jsp";
			 }else {
				 User newUser = userService.registerUser(user, results);
				 session.setAttribute("userId", newUser.getId());
						 
					 return "projects.jsp";
				 }
			 }

		
}
