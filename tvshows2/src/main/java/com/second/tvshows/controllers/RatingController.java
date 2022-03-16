package com.second.tvshows.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.second.tvshows.models.Rating;
import com.second.tvshows.models.User;
import com.second.tvshows.services.RatingService;

@Controller
public class RatingController {

	@Autowired 
	private RatingService ratingService;
	
	@PostMapping("/tvshows/{id}/ratings")
	public String createRating(@PathVariable Long id,
			@Valid @ModelAttribute ("ratings") Rating rating,
			Model model, BindingResult result, HttpSession session) {
		
		User user =(User) session.getAttribute("user");
		if ( user == null) {
			return "redirect:/";
		}
		
		Rating createdRating=ratingService.createRating(rating);
		if(createdRating == null) {
			return "redirect:/";
			
		}
		return "redirect:/ tvshows/{id}";
	}
}
