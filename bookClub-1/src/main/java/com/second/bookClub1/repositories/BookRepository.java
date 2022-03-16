package com.second.bookClub1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.bookClub1.models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findAll();
}
