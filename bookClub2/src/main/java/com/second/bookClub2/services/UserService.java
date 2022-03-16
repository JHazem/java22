package com.second.bookClub2.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.second.bookClub2.models.Book;
import com.second.bookClub2.models.LoginUser;
import com.second.bookClub2.models.User;
import com.second.bookClub2.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // register user and hashed thier password 
    public User registerUser(User user, BindingResult result) {
    	
        // TO-DO: Additional validations!
    	
    	String hashedPassword= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    	user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
    
    //authenticate user
    public boolean authenticateUser(String email, String password) {
    	
    	//First find the user by email
    	User user = userRepository.findByEmail(email);
    	
    	//i we can't find it by email, return false
    	if(user == null) {
    		return false;
    		
    	}else {
    		
    		//if the password match, return true, else return false
    		if(BCrypt.checkpw(password, user.getPassword())) {
    			return true;
    	} else  {
    		return false;
    		}
    	}
    }    
    
    
    //Find user by email
    public User findByEmail(String email) {
    	return  userRepository.findByEmail(email);
    }
    
    //Find user by id
    public User findById(Long id) {
    	return  userRepository.findById(id).orElse(null);
    }
    
    /////////////

    
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
        return null;
    }
    
    public void borrow(User user, Book book) {
    	List<Book> myBooks= user.getBorrowedBooks();
    	myBooks.add(book);
    	System.out.println(user);
    	System.out.println(myBooks);
    	this.userRepository.save(user);
    }
    
    
    public User unBorrow(User user, Book book) {
    	List<Book> myBooks= user.getBorrowedBooks();
    	myBooks.remove(book);
    	
    	return userRepository.save(user);
    }
    
    
    
    
    
}
 













