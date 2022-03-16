package com.second.relationships.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.relationships.models.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	
	User findByEmail(String email);
}
