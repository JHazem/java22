package com.second.books.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.books.models.Book;
import com.second.books.repositories.BookRepository;

@Service
public class BookService {
	
	//p
	@Autowired
	private final BookRepository bookRepository;
	
	//4-1
	public BookService(BookRepository bookRepository) {
	this.bookRepository = bookRepository;
	}
	
    //4-2  returns all the books
    public List<Book> allBooks() {
    	
        return bookRepository.findAll();
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
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    //4-5
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	//4-6
	public Book updateBook( Long    id,
							String  title,
							String  description,
							String  language,
							Integer numOfPages) {
			return null;
	}

	//4-7
	public void updateBook(@Valid Book book) {
		// TODO Auto-generated method stub
		
	}
}
