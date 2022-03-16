package com.second.solo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.second.solo.models.User;
 

@Repository
public interface UserRepository extends CrudRepository<User , Long>{

//    List<User> findAllByJoinedProjectsContains(Item item, Place place);
//    
//    
//    List<User> findByJoinedProjectsNotContains(Item item, Place place);
//    
    
    List<User> findAll();


	User findByEmail(String email);
}
