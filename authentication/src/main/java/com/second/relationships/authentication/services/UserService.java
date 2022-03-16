package com.second.relationships.authentication.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
 
import com.second.relationships.authentication.models.User;
import com.second.relationships.authentication.repositories.UserRepository;

    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // register user and hashed thier password 
    public User registerUser (User newUser, BindingResult result) {
    	
    	String hashedPassword= BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashedPassword);
        return userRepository.save(newUser);
    }
    
    //Find user by email
    public User findByEmail(String email) {
    	return  userRepository.findByEmail(email);
    }
    
    //Find user by id
    public User findById(Long id) {
    	return  userRepository.findById(id).orElse(null);
    }
    
    
    //authenticate user
    public boolean authenticateUser(String email, String password) {
    	//First find the user by email
    	User user =userRepository.findByEmail(email);
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

  

   
}
