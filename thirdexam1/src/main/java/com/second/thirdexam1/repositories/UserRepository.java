package com.second.thirdexam1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.thirdexam1.models.User;

@Repository
public interface UserRepository extends CrudRepository<User , Long>{

	User findByEmail(String email);
}
