package com.second.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.second.relationships.models.Person;
import com.second.relationships.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	public final PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	public List<Person> allPerson(){
		
		return personRepo.findAll();
		}
	
	public Person findLookify(Long id) {
		
		Optional<Person> optionalPerson = personRepo.findById(id);
		
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
			}
		}
	
	
	public Person createLookify(Person l) {
		return personRepo.save(l);
	}
	
	//4-5
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
	
	
	
	
	
}
