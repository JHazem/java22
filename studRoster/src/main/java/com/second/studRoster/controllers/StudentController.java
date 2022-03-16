package com.second.studRoster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import com.second.studRoster.models.Student;
import com.second.studRoster.services.LessonService;
import com.second.studRoster.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private LessonService lessonService;
	

	
//	@GetMapping("/student")
//	public String index(@ModelAttribute("newStudent")Student student) {
//		return "showstudent.jsp";
//	}
	
	//1  student p
	@GetMapping("/students/new")
	public String newStud(@ModelAttribute("newStudent") Student student,
							Model model) {
		
		model.addAttribute("students", studentService.getAllStudent());
		return "newstudent.jsp";
	}

	
	// Create Student
	@PostMapping("/students/create")
	public String createStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "showstudent.jsp";
		}
		else {
			this.studentService.create(student);
			return "redirect:/students/{id}";
		}
	}
	
	@GetMapping("/students/{id}")
	public String student( Model model, Student student,
						  @PathVariable("id") Long id) {
		
		//Lesson mylesson = lessonService.getById(id);
		model.addAttribute("studentLesson", student.getLesson());
		model.addAttribute("student", student);
		model.addAttribute("lessons", this.lessonService.getAllLesson());	
		return "showstudent.jsp";
	}
	
	
	// Get All Student
//	@GetMapping("/showstudent")
//	public String students(Model model,@ModelAttribute("newStudent") Student student) {
//		model.addAttribute("students", this.studentService.getAllStudent());
//		return "showstudent.jsp";
//	}
	
	
	
	  
	// Delete Student
//	@DeleteMapping("/delete/{id}")
//	public String delete(@PathVariable("id") Long id) {
//		this.studentService.deleteStudent(id);
//		return "redirect:/showstudent";
//	}
	

}
