package com.second.exam.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.exam.models.Bundler;
import com.second.exam.models.User;
import com.second.exam.repositories.BundlerRepository;
import com.second.exam.repositories.UserRepository;
  
@Service
public class BundlerService {
	
	@Autowired
	private BundlerRepository bundelerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	 
	
    //4-2  returns all the bundler
	public List<Bundler> allBundlers() {
		return bundelerRepository.findAll();
	}
	
    //Find user by id
	public Bundler findById(Long id) {
		
		return bundelerRepository.findById(id).orElse(null);
	}
 
    //4-3 retrieves a bundler
    public Bundler findBundler(Long id) {
    	
        Optional<Bundler> optionalBundler = bundelerRepository.findById(id);
        
        if(optionalBundler.isPresent()) {
            return optionalBundler.get();
        } 
        else {
            return null;
        } 
    }

	  //4-4 creates a bundler
	public Bundler createBundler(Bundler bundler) {
		return bundelerRepository.save(bundler);
	}
	 
	public Bundler updateBundler(@Valid Bundler bundler) {
	
		return bundelerRepository.save(bundler);
	}
		
		//4-5 delete
	public void deleteBundler(Long id) {
		bundelerRepository.deleteById(id);
	}
	
	//Like
	public void vote(Bundler bundler, User user) {
		user.getVotedFor().add(bundler);
		userRepository.save(user);
	}
	
	//UnLike
	
	public void unVote(Bundler bundler, User user) {
		user.getVotedFor().remove(bundler);
		userRepository.save(user);
	}
	
	
	
	

}
