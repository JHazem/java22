package com.second.relationships.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.relationships.models.Dojo;
import com.second.relationships.models.Ninja;
import com.second.relationships.repositories.DojoRepository;
import com.second.relationships.repositories.NinjaRepository;

@Service
public class DojoNinjaService {

	@Autowired
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	//4-1  p
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	//4-2   List all the dojos  p
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	
	//4-3 retrieves a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo =dojoRepo.findById(id);
		
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
	 //4-4    creates a dojo
	public Dojo creatDojo(Dojo d) {
		return dojoRepo.save(d);
	}

	 //4-4    creates a ninja
	public Ninja creatNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	

	public Dojo saveDojo(@Valid Dojo dojo) {
		// TODO Auto-generated method stub
		return dojoRepo.save(dojo);
	}

	public Ninja saveNinja(@Valid Ninja ninja) {
		// TODO Auto-generated method stub
		return ninjaRepo.save(ninja);
	}

	
}
