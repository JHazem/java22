package com.second.relationships.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.second.relationships.models.LoginUser;
import com.second.relationships.models.User;
import com.second.relationships.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // register user and hashed thier password 
    public User register (User newUser, BindingResult result) {
    	
        // TO-DO: Additional validations!
    	
    	String hashedPassword= BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashedPassword);
        return userRepo.save(newUser);
    }
    
    //Find user by email
    public User findByEmail(String email) {
    	return  userRepo.findByEmail(email);
    }
    
    //Find user by id
    public User findById(Long id) {
    	return  userRepo.findById(id).orElse(null);
    }
    
    
    //authenticate user
    public boolean authenticateUser(String email, String password) {
    	//First find the user by email
    	User user =userRepo.findByEmail(email);
    	//i we can't find it by email, return false
    	if(user==null) {
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
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
        return null;
    }
    
    
}
 