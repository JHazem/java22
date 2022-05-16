package com.second.virtualSchool.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.virtualSchool.models.Teacher;
import com.second.virtualSchool.models.User;
import com.second.virtualSchool.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepo;
	
	
	//4-2   List all the teacher
 	public List<Teacher> allTeachers(){
 		return teacherRepo.findAll();
	}
	
    //Find user by id
	public Teacher findById(Long id) {
		
		return teacherRepo.findById(id).orElse(null);
	}
	
	//4-3 retrieves a Story
	public Teacher findTeacher(Long teacherId) {
		Optional<Teacher> optionalTeacher = teacherRepo.findById(teacherId);
		
		if(optionalTeacher.isPresent()) {
			return optionalTeacher.get();
		}
		else {
			return null;
		}
	} 
	
	 //4-4    creates a Teacher
		public Teacher creatTeacher(Teacher p) {
			return teacherRepo.save(p);
		}
	
		public Teacher saveTeacher(@Valid Teacher teacher) {
			 
			return teacherRepo.save(teacher);
		}

		// cam
		public void addUser(Teacher teacher, User c) {
			c.getTeachers().add(teacher);
			teacherRepo.save(teacher);
		}
	
		//delete
		public void deleteTeacher(Long id) {
			teacherRepo.deleteById(id);
		}
		 
		 
		//Search 
		 
		public List<Teacher> findUserTeacher(Long userId, String txt) {
			 return teacherRepo.findByFirstNameContaining(txt);
		}
	
	
	
	
}
