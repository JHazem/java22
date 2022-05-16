package com.second.storyPedia.services;
  
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.storyPedia.models.Comment;
import com.second.storyPedia.models.User;
import com.second.storyPedia.repositories.CommentRepository; 

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private UserService userservice;
	
	public CommentService(CommentRepository commentRepo) {
		this.commentRepo = commentRepo;
	}

	//31
	public Comment createComment(Comment p) {
		return commentRepo.save(p);
	}
	
	//32
	public Comment saveComment(@Valid Comment comment) { 
		return commentRepo.save(comment);
	}

	//3
	public Comment find(Long id) {
		Optional<Comment> optComment = this.commentRepo.findById(id);
		
		if(optComment.isPresent()) {
			return optComment.get();
		}else{
				return null;
			}
		}
	
	

	//33
	public Comment createComment(Long userId, Comment c) {
		User user = this.userservice.findById(userId);
		if (user == null) {
			return null;
		}else {
			c.setUser(user);
			return this.commentRepo.save(c);
		}
	}
	
	//34
	public Comment findComment(Long commentId) {
		Optional<Comment> optionalComment = commentRepo.findById(commentId);
		
		if(optionalComment.isPresent()) {
			return optionalComment.get();
		}
		else {
			return null;
		}
	}
	
	//35
	public void addUser(Comment comment, User c) {
		c.getComments().add(comment);
		commentRepo.save(comment);
	}
	
	//36
	public void deleteComment(Long id) {
		this.commentRepo.deleteById(id);
	}
	
}

 
