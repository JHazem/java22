package com.second.bookClub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.bookClub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User , Long>{

	User findByEmail(String email);
}
