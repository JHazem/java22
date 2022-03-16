package com.second.pManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.pManager.models.Project;
import com.second.pManager.models.User;

 
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	 
    List<User> findAllByJoinedProjectsContains(Project project);
    
     
    List<User> findByJoinedProjectsNotContains(Project project);
    
    
    List<User> findAll();


	User findByEmail(String email);
    
    
}
