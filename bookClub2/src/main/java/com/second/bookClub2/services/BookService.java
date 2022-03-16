package com.second.bookClub2.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.bookClub2.models.Book;
import com.second.bookClub2.models.User;
import com.second.bookClub2.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	//4-1
	public BookService(BookRepository bookRepository) {
	this.bookRepository = bookRepository;
	}
	
	
    //4-2  returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	

    //Find user by id
	public Book findById(Long id) {
		
		return bookRepository.findById(id).orElse(null);
	}
 
    //4-3 retrieves a book
    public Book findBook(Long id) {
    	
        Optional<Book> optionalBook = bookRepository.findById(id);
        
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } 
        else {
            return null;
        } 
    }

	  //4-4 creates a book
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	 
	public Book updateBook(@Valid Book book) {
		return bookRepository.save(book);
	}
		
		
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	

    public List<Book> notborrow(User currentUser){
		return bookRepository.findAllByBorrowerNotContains(currentUser);
	}
	

}
