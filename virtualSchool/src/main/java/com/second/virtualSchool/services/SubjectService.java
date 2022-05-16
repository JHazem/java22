package com.second.virtualSchool.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.second.virtualSchool.models.Subject;
import com.second.virtualSchool.models.User;
import com.second.virtualSchool.repositories.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepo;
	
	public List<Subject> allSubjects(){
		return subjectRepo.findAll(); 
	}
	
	//Find user by id
	public Subject findById(Long id) {
		return subjectRepo.findById(id).orElse(null);
	}
	
	//4-3 retrieves a place
		public Subject findSubject(Long id) {
			Optional<Subject> optionalSubject = subjectRepo.findById(id);
		
			if(optionalSubject.isPresent()) {
				return optionalSubject.get();
			}
			else {
				return null;
			}
		} 
		
		
		 //4-4    creates a Place
		public Subject creatSubject(Subject p) {
			return subjectRepo.save(p);
		}
	
		public Subject savePlace(@Valid Subject subject) {
			 
			return subjectRepo.save(subject);
		}

		// cam
		public void addUser(Subject subject, User k) {
			k.getSubjects().add(subject);
			subjectRepo.save(subject);
		}
	
		//4-5 delete
		public void deleteSubject(Long id) {
			subjectRepo.deleteById(id);
		}
		 
 
		//Search 
		 
		public List<Subject> findUserPlace(String txt) { // is not searching by user; it is getting results for ALL users with this place
			List<Subject> subjectName = subjectRepo.findBySubjectNameContaining(txt); 
 			
			return subjectName;
		}
		
		
}
	
 
