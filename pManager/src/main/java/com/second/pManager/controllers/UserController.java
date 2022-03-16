package com.second.pManager.controllers;
 
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.second.pManager.models.LoginUser;
import com.second.pManager.models.Project;
import com.second.pManager.models.User;
import com.second.pManager.services.ProjectService;
import com.second.pManager.services.UserService;
import com.second.pManager.validator.UserValidator;
 


@Controller
public class UserController {
 
	 // Add once service is implemented:
	  @Autowired
	  private UserService userService;
	 
	  @Autowired
	  private UserValidator userValidator;
	  
	  //p
	  @GetMapping("/")
	  public String getRegistration(Model model ){
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
	   	
	   	System.out.println("Here");
	 	if(result.hasErrors()) {
 		return "index.jsp";
	 		
	 	}else {
	 		
	 		User newUser = userService.registerUser(user,result);
	 		session.setAttribute("userId", newUser.getId());
	 		redirectAttributes.addFlashAttribute("message","Thank you for registration!");
	 		return "redirect:/projects";
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
         return "redirect:/projects";
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
	 
	 
	 /////////////
	 

	 	@Autowired
		private ProjectService projectService;
 
		
		//1 
		@GetMapping("/users/new")
		public String newUser(@ModelAttribute("addNewUser") User user) {
			return "index.jsp";
		}
		
		
		//2 CODE TO MAKE A NEW user AND SAVE TO THE DB
		@PostMapping("/users/new")
		public String addUser( @Valid @ModelAttribute("addNewUser") User user,
							    	 BindingResult result) {
			if(result.hasErrors()) {
				return "index.jsp";
			}
			else {
				User thisuser = userService.creatUser(user);
				Long id = thisuser.getId();
				return "redirect:/users/" +id ; 
			}
		}
		
		
		//3    p/2
		@GetMapping("/users/{id}")
		public String showUser( Model model,
								@PathVariable("id") Long id) {
			User user = userService.findUser(id);
			
			model.addAttribute("user", user);
			model.addAttribute("myprojects",user.getProjects());
			model.addAttribute("projects", projectService.allProjects());
			return "dashboard.jsp";
		}
		
		@PostMapping("/users/{id}")
		public String addProject(@PathVariable("id") Long id,
								 @RequestParam("project")Long idprod) {
			Project findProject = projectService.findProject(idprod);
			User thisUser = userService.findUser(id);
			
			//List<Project> projects = thisUser.getProjects(); 
			userService.addProject(findProject, thisUser);
			return "redirect:/users/{id}" ;
		}
		
		
		

}
