package com.second.testexam.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.testexam.models.BabyName;
import com.second.testexam.models.User;
import com.second.testexam.repositories.BabyNameRepository;
import com.second.testexam.repositories.UserRepository;

@Service
public class BabyNameService {
	
	@Autowired
	private BabyNameRepository babyNameRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
   //4-2  returns all the babyName
	public List<BabyName> allBabyNames() {
		return babyNameRepository.findAll();
	}
	

   //Find user by id
	public BabyName findById(Long id) {
		
		return babyNameRepository.findById(id).orElse(null);
	}

   //4-3 retrieves a BabyName
   public BabyName findBabyName(Long id) {
   	
       Optional<BabyName> optionalBabyName = babyNameRepository.findById(id);
       
       if(optionalBabyName.isPresent()) {
           return optionalBabyName.get();
       } 
       else {
           return null;
       } 
   }

	  //4-4 creates a BabyName
	public BabyName createBabyName(BabyName babyName) {
		return babyNameRepository.save(babyName);
	}
	 
	public BabyName updateBabyName(@Valid BabyName babyName) {
	
		return babyNameRepository.save(babyName);
	}
		
		//4-5 delete
	public void deleteBabyName(Long id) {
		babyNameRepository.deleteById(id);
	}
	
	//Like
	public void vote(BabyName babyname, User user) {
		user.getVotedFor().add(babyname);
		userRepository.save(user);
	}
	
	//UnLike
	
	public void unVote(BabyName babyName, User user) {
		user.getVotedFor().remove(babyName);
		userRepository.save(user);
	}
	
}
