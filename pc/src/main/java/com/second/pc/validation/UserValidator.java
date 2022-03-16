package com.second.pc.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.second.pc.models.User;
import com.second.pc.repositories.UserRepository;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override		 	//errors should match211  result
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		User user = (User) target;
		
		if(!user.getConfirm().equals(user.getPassword())){
			errors.rejectValue("password",  "Match", "passsword dos not match");	
		}
		
		if(userRepository.findByEmail(user.getEmail()) !=null) {
			errors.rejectValue("email",  "uniqe", "email address already taking");
		}
	}

	// if(!user.getPassConfirm().equals(user.getPassword())) {
	// errors.rejectValue("passConfirm",  "Match");
	
}
