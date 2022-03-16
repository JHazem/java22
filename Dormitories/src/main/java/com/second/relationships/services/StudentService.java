package com.second.relationships.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.relationships.models.Dormitory;
import com.second.relationships.models.Student;
import com.second.relationships.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studRepo; 
	
	
	//4-2   List all student
	public List<Student> getAllStudents(){
		return studRepo.findAll();
	}
	
	
	//4-3 retrieves a student
	public Student findStudent (Long id) {
		Optional <Student> optionalStudent= studRepo.findById(id);
		
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}else {
			return null;
			}
		}
	
	//4-4    creates student
	public Student createStudent(Student s) {
		return studRepo.save(s);
	}
			
	//save  student
	public void allStudents(@Valid Student student) {
		// TODO Auto-generated method stub
		studRepo.save(student);
	}
	
	//save  Dormitory
	public void setDorm(Dormitory dorm, Student student) {
		student.setDormitory(dorm);
		studRepo.save(student);
	}

	//delete  student
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studRepo.deleteById(id);
	}
	
	
	
	
	
	
}
