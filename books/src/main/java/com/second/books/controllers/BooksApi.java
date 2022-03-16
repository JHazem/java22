package com.second.books.controllers;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.second.books.models.Book;
import com.second.books.services.BookService;

@RestController
public class BooksApi {

@Autowired
 private final BookService bookService;

//1-1
 public BooksApi(BookService bookService){
     this.bookService = bookService;
 }
 
 //1-2
 @RequestMapping("/api/books")
 public List<Book> index() {
     return bookService.allBooks();
 }

 //1-3    Create
 @RequestMapping(value="/api/book", method=RequestMethod.POST)
 public Book create(@RequestParam(value="title") String title,
					 @RequestParam(value="description") String description, 
					 @RequestParam(value="language") String language, 
					 @RequestParam(value="pages") Integer numOfPages) {
	 
     Book book = new Book(title, description, language, numOfPages);
     return bookService.createBook(book);
 }
 
 //1-4   Show
 @RequestMapping("/api/book/{id}")
 public Book show(@PathVariable("id") Long id) {
     Book book = bookService.findBook(id);
     return book;
 }
 
 //1-5    other methods removed for brevity
 @RequestMapping(value="/api/book/update/{id}", method=RequestMethod.PUT)
 public Book update(@PathVariable("id") Long id, @RequestParam(value="title")		 String title,
												 @RequestParam(value="description")  String description,
												 @RequestParam(value="language") 	 String language,
												 @RequestParam(value="pages")		 Integer numOfPages) {
    Book book = bookService.updateBook(id, title, description, language, numOfPages);
     return book;
 }
 
 //1-6
 @RequestMapping(value="/api/book/delete/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     bookService.deleteBook(id);
 }
 
 //1-7
 //@DeleteMapping("{id}")
 public  ResponseEntity<String> deletBook(@PathVariable("id") long id){
	 bookService.deleteBook(id);
	 return new ResponseEntity<String>("Book deleted successfully!", HttpStatus.OK);
 }
 
}




