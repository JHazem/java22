package com.second.pManager.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.second.pManager.models.LoginUser;
import com.second.pManager.models.Project;
import com.second.pManager.models.User;
import com.second.pManager.repositories.UserRepository; 
 
@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	

	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	  //User registration and hashed thier password 
    public User registerUser(User user, BindingResult result) {
    	
        // TO-DO: Additional validations!
    	
    	String hashedPassword= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    	user.setPassword(hashedPassword);
        return userRepo.save(user);
    }

       
	//Find user by email
	public User findByEmail(String email) {  
		return userRepo.findByEmail(email);
	}

	//Find user by id
	public User findById(Long id) {
		 
		return userRepo.findById(id).orElse(null);
	}
  		
    
    //authenticate user
    public boolean authenticateUser(String email, String password) {
    	
    	//First find the user by email
    	User user = userRepo.findByEmail(email);
    	
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
    
  		//////////////
	
	public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
        return null;
    }
	
	//join
   public void join(User user, Project project) {
    	List<Project> myProjects= user.getJoinedProjects();
    	myProjects.add(project);
    	this.userRepo.save(user);
    }
    
    //unJoin
    public User unJoin(User user, Project project) {
    	List<Project> myProjects= user.getJoinedProjects();
    	myProjects.remove(project);
    	
    	return userRepo.save(user);
    }
	    
	
	//4-3 retrieves a User
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
	 
	 //4-4    creates a User
		public User creatUser(User c) {
			return userRepo.save(c);
		}
	
		public User saveUser(@Valid User user) {
			 
			return userRepo.save(user);
		}
	
		// cam
		public void addProject(Project p, User user) {
			p.getUser().getJoinedProjects();
			userRepo.save(user);
		}
  		

		    
	 

	
	
		//4-1
//		public UserService(UserRepository userRepo) {
//			this.userRepo = userRepo;
//		}
		
		//4-2   List all the User
//		public List<User> allProject(){
//			return (List<User>) userRepo.findAll();
//		}
		
//	    public User registerUser(User newEntry) {
//        String hash = BCrypt.hashpw(newEntry.getPassword(), BCrypt.gensalt());
//        newEntry.setPassword(hash);
//        return this.userRepo.save(newEntry);
//    }
    
		//authenticate user
//    public boolean authenticateUser(String email, String password) {
//        User user = this.findByEmail(email);
//        
//        if(user == null) {
//            return false;
//        }else if(user != null && user.getEmail().equals(email)){
//            return BCrypt.checkpw(password, user.getPassword());
//        }else {
//        return false;
//        }
//    }
		
		
}
