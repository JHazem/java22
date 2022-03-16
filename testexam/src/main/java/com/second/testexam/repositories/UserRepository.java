package com.second.testexam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.testexam.models.User;

@Repository
public interface UserRepository extends CrudRepository<User , Long>{

	User findByEmail(String email);
}
