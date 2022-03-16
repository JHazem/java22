package com.second.pc.repositories;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.pc.models.User;

@Repository
public interface UserRepository extends CrudRepository<User , Long>{

	User findByEmail(String email);
}
