package com.second.solo.services;
 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.solo.models.Comment;
import com.second.solo.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	public CommentService(CommentRepository commentRepo) {
		this.commentRepo = commentRepo;
	}

	public Comment createComment(@Valid Comment comment) {

		return commentRepo.save(comment);
		
		
	}
	
	
}
