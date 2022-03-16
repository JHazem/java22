package com.second.relationships.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.relationships.models.Dormitory;
import com.second.relationships.models.Student;
import com.second.relationships.repositories.DormRepository;

@Service
public class DormitoryService {

	@Autowired
	private DormRepository dormRepo; 
	
	
	//4-4    creates  dorm
	public Dormitory createDormitroy(Dormitory d) {
		return dormRepo.save(d);
	}
	
	
	public void allDormitories(@Valid Dormitory dormitory) {
		// TODO Auto-generated method stub
		dormRepo.save(dormitory);
	}
	
	
	public Object getAllDormitories() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Dormitory getById(Long id) {
		return this.dormRepo.findById(id).orElse(null);
	}
	
	public Dormitory addStudent(Long dormId,Student student) {
		
		Dormitory mydorm = this.getById(dormId);
		List<Student> myStudent = mydorm.getStudents();
		myStudent.add(student);
		
		return dormRepo.save(mydorm);
	}
	
}
