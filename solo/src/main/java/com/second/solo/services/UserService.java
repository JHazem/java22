package com.second.solo.services;
 

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.second.solo.models.LoginUser; 
import com.second.solo.models.User;
import com.second.solo.repositories.UserRepository; 

   
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
    
 
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
        return null;
    }
    
    
      //////////
 	//4-3 retrieves a User
// 	public User findUser(Long id) {
// 		Optional<User> optionalUser = userRepository.findById(id);
// 		
// 		if(optionalUser.isPresent()) {
// 			return optionalUser.get();
// 		}
// 		else {
// 			return null;
// 		}
// 	}
 	 
 	 //4-4    creates a User
// 		public User creatUser(User c) {
// 			return userRepository.save(c);
// 		}
// 	
// 		public User saveUser(@Valid User user) {
// 			 
// 			return userRepository.save(user);
// 		}
 	
 	 
   		
    
}
 