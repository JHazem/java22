package com.second.pManager.controllers;
  
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

import com.second.pManager.models.Project;
import com.second.pManager.models.User;
import com.second.pManager.services.ProjectService;
import com.second.pManager.services.UserService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	  
	//1
    @GetMapping("/projects" )
    public String indexpage(Model model,HttpSession session) {
    	
		 // If there is no attribute "user_id" on session, then redirect to index page
	    Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/";
	    }
	     else {
	        User currentUser = this.userService.findUser(userId); 
	        model.addAttribute("user",currentUser);
	        List<Project> joinProjects = projectService.join(currentUser);
		    List <Project> notmyprojects = projectService.notjoin(currentUser);
	        
		    //System.out.println("not"+notmyprojects); 
		    //System.out.println("my"+joinProjects.size());
	        
		    model.addAttribute("myProjects", joinProjects);
	        model.addAttribute("notMyProjects", notmyprojects);
		  	 
	        return "dashboard.jsp";
	    }
        
    }
    
    //2
    @GetMapping("/projects/{projectId}")
	public String sProject( Model model,
							@PathVariable("projectId") Long projectId) {
		
		Project project = projectService.findProject(projectId); 
		model.addAttribute("project",project);

		return "detail.jsp";
	}
	
    	//4 
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("addNewProject") Project project,HttpSession session,Model model) {
		
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  model.addAttribute("thisUser",  thisUser);
		return "addproject.jsp";
	}
  		
  		
	//2  CODE TO MAKE A NEW user AND SAVE TO THE DB  1
	@PostMapping("/projects")
	public String addProject(@Valid @ModelAttribute("project") Project project,
							 	BindingResult result) {
		if(result.hasErrors()) {
			return "addproject.jsp";
		}
		else {
			//Project thisproject =projectService.creatProject(project);
			//Long id =thisproject.getId();
			//return "redirect:/projects/" + id ;
			
			projectService.creatProject(project);
			return "redirect:/projects";
		}
	}
	
	
	// edit
		@GetMapping("/projects/{id}/edit")
		   public String edit(@PathVariable("id") Long id, Model model) {
		       Project project = projectService.findProject(id);
		       model.addAttribute("project", project);
		       System.out.println(project.getUser().getId());
		       return "edit.jsp";
		   }
		
	
		//6
		@PostMapping("/projects/{id}")
		   public String update(@Valid @ModelAttribute("project") Project project, BindingResult result) {
		       if (result.hasErrors()) {
		           return "edit.jsp";
		       } else {
		    	  // System.out.println(project.getUser().getId());
		           projectService.saveProject(project);
		           return "redirect:/projects";
		       }
		   }
		
		
		//delete
		@GetMapping("/projects/delete/{id}")
		  public String destroy(@PathVariable("id") Long id) {
			projectService.deleteProject(id);
		      return "redirect:/projects";
		  }
		
	 	
		
		// join team table
	
		 //Join project
		@GetMapping("/projects/join/{projectId}")
		public String joinTeam( Model model,
								@PathVariable("projectId") Long projectId,HttpSession session) {
			System.out.println("Join");
			  Long id = (Long)session.getAttribute("userId");
			  User thisUser = userService.findUser(id);
			  userService.join(thisUser, projectService.findById(projectId));

			  return "redirect:/projects";
		  }
		
		@GetMapping("/projects/return/{projectId}")
		public String returnProject ( Model model,
								@PathVariable("projectId") Long projectId,HttpSession session) {

			  Long id = (Long)session.getAttribute("userId");
			  User thisUser = userService.findById(id);
			  userService.unJoin(thisUser, projectService.findById(projectId));

			  return "redirect:/projects";
		  }
		

		
		
		//3    p/2
//		@GetMapping("/projects/{id}")
//		public String showProject( Model model,
//							@PathVariable("id") Long id) {
//			Project project = projectService.findProject(id);
//			
//			model.addAttribute("project", project);
//			model.addAttribute("myusers", project.getUser());
//			model.addAttribute("users", userService.allUsers());
//			return "dashboard.jsp";
//		}
		


		
	
}
