package com.second.relationships.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.second.relationships.models.User;
import com.second.relationships.repositories.UserRepository;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override								//match211  result
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		User user = (User) target;
		if(user.getConfirm().equals(user.getEmail())){
			errors.rejectValue("password",  "Match", "passsword dos not match");	
		}
		
		if(userRepo.findByEmail(user.getEmail()) !=null) {
			errors.rejectValue("email",  "uniqe", "email address already taking");
		}
	}

	// if(!user.getPassConfirm().equals(user.getPassword())) {
	// errors.rejectValue("passConfirm",  "Match");
	
}
