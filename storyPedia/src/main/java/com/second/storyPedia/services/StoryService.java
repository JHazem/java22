package com.second.storyPedia.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.storyPedia.models.Story;
import com.second.storyPedia.models.User;
import com.second.storyPedia.repositories.StoryRepository; 

 
@Service
public class StoryService {

	@Autowired
	private StoryRepository storyRepo;
	
//	@Autowired
//	private UserRepository userRepository;
	
	
	
	//4-2   List all the Story
 	public List<Story> allStories(){
 		return storyRepo.findAll();
	}
	
    //Find user by id
	public Story findById(Long id) {
		
		return storyRepo.findById(id).orElse(null);
	}
	
	//4-3 retrieves a Story
	public Story findStory(Long storyId) {
		Optional<Story> optionalStory = storyRepo.findById(storyId);
		
		if(optionalStory.isPresent()) {
			return optionalStory.get();
		}
		else {
			return null;
		}
	} 
	
	 //4-4    creates a Story
		public Story creatStory(Story p) {
			return storyRepo.save(p);
		}
	
		public Story saveStory(@Valid Story story) {
			 
			return storyRepo.save(story);
		}

		// cam
		public void addUser(Story story, User c) {
			c.getStories().add(story);
			storyRepo.save(story);
		}
	
		//delete
		public void deleteStory(Long id) {
			storyRepo.deleteById(id);
		}
		
		

		 
		//Search 
		 
		public List<Story> findUserStory(Long userId, String txt) {
			 return storyRepo.findByTitleContaining(txt);
		}
		
 
		//Like Service
//		public void like(Story story, User user) {
//			user.getLikedFor().add(story);
//			userRepository.save(user);
//		}
//		
//		//UnLike Service
//		
//		public void unLike(Story story, User user) {
//			user.getLikedFor().remove(story);
//			userRepository.save(user);
//		}
 	
}
