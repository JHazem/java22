package com.second.tvshows.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.tvshows.models.Rating;
import com.second.tvshows.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}
	
	public Rating updateRating(@Valid Rating rating) {
		return ratingRepository.save(rating);
	}
	
}
