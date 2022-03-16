package com.second.lookify.LookifyService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.lookify.Repositories.LookifyRepository;
import com.second.lookify.models.Lookify;

@Service
public class LookifyService {
	
	//p
	@Autowired
	private final LookifyRepository lookifyRepository;
	
	//4-1
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	//4-2  returns all the lookify
	public List<Lookify> allLookify(){
		
		return lookifyRepository.findAll();
		}
	
	//4-3 retrieves a lookify   p
	public Lookify findLookify(Long id) {
		
		Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
		
		if(optionalLookify.isPresent()) {
			return optionalLookify.get();
		}
		else {
			return null;
			}
		}
	
		//4-4    creates a lookify   p
		public Lookify createLookify(Lookify l) {
			return lookifyRepository.save(l);
		}
		
		//4-5
		public void deleteLookify(Long id) {
			lookifyRepository.deleteById(id);
		}
		
		//4-6
		public Lookify updateLookify(	Long   id,
										String  name,
										String  artist,
										Integer rating) {
			return null;
		}
		
		//4-7
		public void updateLookify(@Valid Lookify lookify) {
			lookifyRepository.save(lookify);
		}
	 
	}
 
 
