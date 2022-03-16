package com.second.relationships.authentication.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.relationships.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	//List<User> findAll();
	//Optional<User> findByEmail(String email);
	User findByEmail(String email);
	
}
