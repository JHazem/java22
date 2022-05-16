package com.second.storyPedia.services;
 

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.second.storyPedia.models.LoginUser;
import com.second.storyPedia.models.User;
import com.second.storyPedia.repositories.UserRepository; 

   
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
  
    // register user and hashed thier password   1
    public User registerUser(User user) {
    	 
    	String hashedPassword= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    	user.setPassword(hashedPassword);
        return userRepository.save(user);
    }
     
    //Find user by email  2
    public User findByEmail(String email) {
    	return  userRepository.findByEmail(email);
    }
    
    //Find user by id 3
    public User findById(Long id) {
    	return  userRepository.findById(id).orElse(null);
    }
    
    
    //authenticate user  4
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
    
    
    //5
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
        return null;
    }
    
  
   		
    
}
 