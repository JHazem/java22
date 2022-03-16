package com.second.bookClub2.repositories;
 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.second.bookClub2.models.User;

@Repository
public interface UserRepository extends CrudRepository<User , Long>{

	User findByEmail(String email);

	//For borrow book
	//List<Book> findAllByBooks(List<Book> myBooks);
	
}
