package com.second.storyPedia.controllers;
   
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.second.storyPedia.models.Comment;
import com.second.storyPedia.services.CommentService; 

@Controller
public class CommentController {
	
	@Autowired 
	private CommentService commentService;
	
//	@Autowired 
//	private UserService userService;

	//51
	@PostMapping("/addcomment/{story_id}")
	public String addComment(@Valid @ModelAttribute ("commentObject") Comment comment,
			BindingResult result,
			@PathVariable("story_id") Long id){
	
		if(result.hasErrors()) {
			return "redirect:/stories/" +id;
		}else { 
		
		commentService.createComment(comment);
		
		return "redirect:/stories/{story_id}";
		}
	}
	
	
	
	//5 edit
	@GetMapping("/comments/{id}/edit")
	   public String editComment(@ModelAttribute("commentObject") Comment formcomment, @PathVariable("id") Long id, Model model) {
	       Comment comment = commentService.findComment(id);
	       model.addAttribute("comment", comment); 
	       return "editcomment.jsp";
	   }
	

	//6
	@PostMapping("/comments/{id}")
	   public String updateComment(@Valid @ModelAttribute("commentObject") Comment comment, BindingResult result) {
	       if (result.hasErrors()) {
	           return "editstory.jsp";
	       } else { 
	           commentService.saveComment(comment);
	           return "redirect:/stories/{story_id}";
	       }
	   }
	
	
	//delete
	@GetMapping("/delete/{commentId}/{storyId}")
	  public String destroyComment(@PathVariable("commentId") Long commentId,@PathVariable("storyId") Long id) {
		commentService.deleteComment(commentId);
	      return "redirect:/stories/{storyId}";
	  }
	
	 
	
	
}	
  
 
