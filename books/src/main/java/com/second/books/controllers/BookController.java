package com.second.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.second.books.models.Book;
import com.second.books.services.BookService;

@Controller
public class BookController {

	@Autowired 
	BookService bookService;
	
	//1
    @RequestMapping("/books" )
    public String indexpage(Model model) {
    	
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
     
    //2
	@GetMapping("/books/{bookId}")
	public String showBook( Model model,
							@PathVariable("bookId") Long bookId) {
		
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book",book);

		return "show.jsp";
	}


	//4
	//Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/books")
	public String createNew(@Valid @ModelAttribute("book") Book book,
	  						  BindingResult result) 
	{
	  // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	if(result.hasErrors()) {
	return "new.jsp";
  	}

	bookService.createBook(book);
	
	return "redirect:/books";
	}

  //4..
  @GetMapping("/books/new")
  public String newBook(@ModelAttribute("book") Book book) {
  	
  	return "new.jsp";
  }

   //5     Edit and Update  
   // other methods removed for brevity
   @GetMapping("/books/{id}/edit")
   public String edit(@PathVariable("id") Long id, Model model) {
       Book book = bookService.findBook(id);
       model.addAttribute("book", book);
       return "edit.jsp";
   }
   
   //6
   @PutMapping("/books/{id}")
   public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
       if (result.hasErrors()) {
           return "edit.jsp";
       } else {
           bookService.updateBook(book);
           return "redirect:/books";
       }
   }


	//7    Delete
	@DeleteMapping("/books/{id}")
	 public String destroy(@PathVariable("id") Long id) {
	     bookService.deleteBook(id);
	     return "redirect:/books";
	 }


}


 
