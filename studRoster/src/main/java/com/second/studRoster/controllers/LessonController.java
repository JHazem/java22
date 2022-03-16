package com.second.studRoster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping; 
import com.second.studRoster.models.Lesson; 
import com.second.studRoster.services.LessonService;
import com.second.studRoster.services.StudentService;

@Controller
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	

	@Autowired
	private StudentService studentService;

	@GetMapping("/lesson")
	public String index(@ModelAttribute("newLesson")Lesson lesson) {
		return "showlesson.jsp";
	} 
	
	//1  lesson p
	@GetMapping("/lessons/new")
	public String newLesson(@ModelAttribute("newLesson") Lesson lesson,
							Model model) {
		
		model.addAttribute("lessons", lessonService.getAllLesson());
		return "newlesson.jsp";
	}
		
	// Create Lesson
	@PostMapping("/lessons/create")
	public String createStudent(@Valid @ModelAttribute("newLesson") Lesson lesson, BindingResult result) {
		if(result.hasErrors()) {
			return "/newlesson.jsp";
		}
		else {
			this.lessonService.create(lesson);
			return "redirect:/showlesson";
		}
	}
	
	
	// Get All Lesson
//	@GetMapping("/showlesson")
//	public String lessons(Model model,@ModelAttribute("newlesson") Lesson lesson) { 
//		model.addAttribute("lesson",this.lessonService.getAllLesson());
//		return "showlesson.jsp";
//	}
	
	@GetMapping("/lessons/{id}")
	public String lesson( Model model, Lesson lesson,
						@PathVariable("id") Long id) {
		
		//Lesson mylesson = lessonService.getById(id);
		model.addAttribute("lessonStudent", lesson.getStudents());
		model.addAttribute("lesson", lesson);
		model.addAttribute("students", this.studentService.getAllStudent());	
		return "showlesson.jsp";
	}
	
	
	// Delete Losson
	@DeleteMapping("/lesson/delete/{id}")
	public String deletelesson(@PathVariable("id") Long id) {
		this.lessonService.deleteLesson(id);
		return "redirect:/showlosson";
	}
	
	 
	
	
	
	
	
	
}
