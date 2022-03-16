package com.second.testlogin.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.second.testlogin.models.Book;
import com.second.testlogin.models.User;
import com.second.testlogin.services.BookService;
import com.second.testlogin.services.UserService;
 
@Controller
public class BookController {

	@Autowired 
	private BookService bookService;
	
	@Autowired 
	private final UserService userService =null;
	

	//1
    @GetMapping("/books" )
    public String indexpage(Model model,HttpSession session) {
    	
    	 // If there is no attribute "user_id" on session, then redirect to index page
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        
        // Else render the page and pass all the necessary attributes to the showsDashboarb page and return it
        else {
            User currentUser = this.userService.findById(userId);
            List<Book> books = bookService.allBooks();
            model.addAttribute("user",currentUser);
            model.addAttribute("books", books);
            return "dashboard.jsp";
             
        }
        
    

    }
     
    //2
	@GetMapping("/books/{bookId}")
	public String showBook( Model model,
							@PathVariable("bookId") Long bookId) {
		
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book",book);

		return "detail.jsp";
	}


	  //4.. add new book       
	  @GetMapping("/books/new")
	  public String newBook(@ModelAttribute("book") Book book,HttpSession session, Model model) {
		  
		  Long id = (Long)session.getAttribute("userId");
		  User thisUser = userService.findById(id);
		  model.addAttribute("thisUser",  thisUser);
	  	return "addBook.jsp";
	  }
	  
	  
	//4
	//Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/books")
	public String createNew(@Valid @ModelAttribute("book") Book book,
					
	  						  BindingResult result) 
	{
	  // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	if(result.hasErrors()) {
	
	return "addBook.jsp";
  	}

	bookService.createBook(book);
	
	return "redirect:/books";
	}


   //5     Edit and Update  
   // other methods removed for brevity
   @GetMapping("/books/{id}/edit")
   public String edit(@PathVariable("id") Long id, Model model) {
       Book book = bookService.findBook(id);
       model.addAttribute("book", book);
       
	   System.out.println("GET");
	   System.out.println(book);
	   System.out.println(book.getTitle());
	   System.out.println(book.getAutherName());
	   System.out.println(book.getThoughts());
	   System.out.println(book.getId());
	   System.out.println(book.getUser());
	     
       return "edit.jsp";
   }
   
   //6
   @PutMapping("/books/{id}")
   public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
       if (result.hasErrors()) {
           return "edit.jsp";
       } else {
    	   System.out.println("PUT");
    	   System.out.println(book);
    	   System.out.println(book.getTitle());
    	   System.out.println(book.getAutherName());
    	   System.out.println(book.getThoughts());
    	   System.out.println(book.getId());
    	   System.out.println(book.getUser());
    	   
           bookService.updateBook(book);
           return "redirect:/books";
       }
   }

 //Delete
   
	 @GetMapping("/books/delete/{id}")
	  public String destroy(@PathVariable("id") Long id) {
	      bookService.deleteBook(id);
	      return "redirect:/books";
	  }
 

}
