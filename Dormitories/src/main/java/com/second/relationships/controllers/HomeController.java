package com.second.relationships.controllers;

 
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

import com.second.relationships.models.Dormitory;
import com.second.relationships.models.Student;
import com.second.relationships.services.DormitoryService;
import com.second.relationships.services.StudentService;


@Controller
public class HomeController {

	@Autowired
	private StudentService studentService;
	
	@Autowired 
	private DormitoryService dormitoryService;


//	@GetMapping("/dormitories")
//    public String index(@ModelAttribute("backNew") Dormitory dormitory, Model model) {
//    	
//            Object dormitories = dormitoryService.getAllDormitories();
//            		
//            model.addAttribute("dormitories", dormitories);
//            return "show.jsp";
//    }
	
	//1  dorm p
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("addNewDorm") Dormitory dormitory) {
		
		return "newdorm.jsp";
	}
	 
	
	//2  CODE TO MAKE A NEW dorm AND SAVE TO THE DB
	@PostMapping("/new/dorms")
	public String addDorm(@Valid @ModelAttribute("addNewDorm") Dormitory dormitory, BindingResult result) {
		if(result.hasErrors()) {
			return "newstudent.jsp";
		}
		else {
			 dormitoryService.createDormitroy(dormitory);
			return "redirect:/students/new";
		}
	}
		 
	
	//1  student p
	@GetMapping("/students/new")
	public String newStud(@ModelAttribute("addNewStudent") Student student,
							Model model) {
		
		model.addAttribute("students", studentService.getAllStudents());
		return "newstudent.jsp";
	}
	
	 
	//2 CODE TO MAKE A NEW Student AND SAVE TO THE DB
	@PostMapping("/students/add")
	public String addStudent(@Valid @ModelAttribute("addNewStudent") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "newstudent.jsp";
		}
		else {
			studentService.createStudent(student);
			return "redirect:/students/new";
		}
	}
	
	@GetMapping("/show")
	public String showPage() {
		return "show.jsp";
	}
	 
	@GetMapping("/dorms/{id}")
	public String Dormitory( Model model,
						@PathVariable("id") Long id) {
		Dormitory dormitory = dormitoryService.getById(id);
		model.addAttribute("dormStudent", dormitory.getStudents());
		model.addAttribute("dorm", dormitory);
		model.addAttribute("students", this.studentService.getAllStudents());	
		return "show.jsp";
	}
	
	// to add student to table
	@PostMapping("/dorms/addStudent/{id}")
	public String studentForm(@RequestParam("student") Student student,
								@PathVariable("id") Long dormId) {
		
		//dormitoryService.addStudent(dormId, student); 
		studentService.setDorm(dormitoryService.getById(dormId), student);
		return "redirect:/dorms/{id}";
	}
	
   //delete
    @GetMapping("/students/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
 	   studentService.deleteStudent(id);
        return "redirect:/dorms/addStudent";
    }
    
    
    
    
    
}
