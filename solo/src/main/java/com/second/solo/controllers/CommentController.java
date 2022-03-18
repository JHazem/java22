package com.second.solo.controllers;
  
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.second.solo.models.Comment; 
import com.second.solo.services.CommentService;  

@Controller
public class CommentController {
	
	@Autowired 
	private CommentService commentService;

	
	@PostMapping("/mystories/{id}")
	public String addComment(@Valid @ModelAttribute
			("commentObject") Comment comment,
			 BindingResult result,@PathVariable("id") Long id){


		if(result.hasErrors()) {
			return "redirect:/stories/" +id;
		}else {
			 
		System.out.println("*****");
		commentService.createComment(comment);
		//Long commId = comment .getStory().getId();
		return "redirect:/stories/{id}";
		}
	}
	

	
	
	
	

}
