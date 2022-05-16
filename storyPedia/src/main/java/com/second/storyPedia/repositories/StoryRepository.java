package com.second.storyPedia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.storyPedia.models.Story; 

@Repository
public interface StoryRepository extends CrudRepository<Story, Long>{
 
  
	List<Story> findAll();
	List<Story> findByTitleContaining(String title); 
 
}
 