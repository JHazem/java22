package com.second.virtualSchool.controllers;

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

import com.second.virtualSchool.models.Schedule;
import com.second.virtualSchool.models.Subject;
import com.second.virtualSchool.models.Teacher;
import com.second.virtualSchool.models.User;
import com.second.virtualSchool.services.CurriculumService;
import com.second.virtualSchool.services.ScheduleService;
import com.second.virtualSchool.services.SubjectService;
import com.second.virtualSchool.services.TeacherService;
import com.second.virtualSchool.services.UserService;

@Controller
public class TeacherControlleer {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private CurriculumService curriculumService;
	
	@Autowired
	private final UserService userService= null;
	 
	//1
    @GetMapping("/teachers" )
    public String storypage(Model model,HttpSession session) {
    	
	    Long userId = (Long) session.getAttribute("userId");
	    if (userId == null) {
	        return "redirect:/";
	    }
	     else {
	        User currentUser = this.userService.findById(userId); 			
	        
	        List<Teacher> joinTeachers = teacherService.allTeachers(); // to appear the table contain 
	        model.addAttribute("myTeachers", joinTeachers);   
	        
	        // - - - - - - - - Search
	        if(session.getAttribute("title") !=null) {   //Search 
	        	 String keyword = (String)session.getAttribute("firstName");   //Search 
	        	  model.addAttribute("teachers",teacherService.findUserTeacher(userId,keyword));  //Search 
	        	  session.removeAttribute("firstName");// to appear the table contain 
	         }else {          
	        	model.addAttribute("teachers", teacherService.allTeachers());   //Search 
	         }
	        // - - - - - - - -
	        
	        model.addAttribute("user",currentUser);  
 		    
	        return "teachertable.jsp";
	    }
        
    }
	
    //2
    @GetMapping("/teachers/{teacherId}")
	public String showTeacher (Model model,
							@PathVariable("teacherId") Long teacherId,   HttpSession session) {
		
		Teacher teacher = teacherService.findTeacher(teacherId);
		model.addAttribute("teacher",teacher);
		 
		return "detailteacher.jsp";
	}
	 
    
  	//4 .. add new teacher
	@GetMapping("/teachers/new")
	public String newTeacher(@ModelAttribute("addNewTeacher") Teacher teacher,HttpSession session,Model model) {
		 List<Subject> joinSubjects = subjectService.allSubjects();
		 List<Schedule> joinSchedules = scheduleService.allSchedules();
		
		  model.addAttribute("subjects", joinSubjects);// for add subject as a down arrow
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  
		  model.addAttribute("subject", joinSubjects);
		  model.addAttribute("thisUser",  thisUser);
		return "addteacher.jsp";
	}
  		
  		
	//2  CODE TO MAKE A NEW user AND SAVE TO THE DB  1
	@PostMapping("/teacher.s")
	public String addTeacher(@Valid @ModelAttribute("addNewTeacher") Teacher teacher,
							 	BindingResult result) {
		if(result.hasErrors()) {
			return "addteacher.jsp";
		}
		else {
			
			teacherService.creatTeacher(teacher);
			return "redirect:/teachers";
		}
	}
	
	
	//5 edit
		@GetMapping("/teachers/{id}/edit")
		   public String editTeacher(@PathVariable("id") Long id, Model model) {
		       Teacher teacher = teacherService.findTeacher(id);
		       model.addAttribute("teacher", teacher); 
		       return "editteacher(.jsp";
		   }
		

		//6
		@PostMapping("/teachers/{id}")
		   public String updateTeacher(@Valid @ModelAttribute("teacher") Teacher teacher, BindingResult result) {
		       if (result.hasErrors()) {
		           return "editteacher.jsp";
		       } else { 
		           teacherService.saveTeacher(teacher);
		           return "redirect:/teachers";
		       }
		   }
		
		
}
