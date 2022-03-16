package com.second.books.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.books.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>{
	//3-1
	List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
}
