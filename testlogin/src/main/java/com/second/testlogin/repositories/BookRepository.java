package com.second.testlogin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.testlogin.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findAll();
}
