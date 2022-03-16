package com.second.solo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
 
import com.second.solo.models.Story;
import com.second.solo.models.User;
import com.second.solo.repositories.StoryRepository;

 
@Service
public class StoryService {

	@Autowired
	private StoryRepository storyRepo;
	

	
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
		
 
 	
}
