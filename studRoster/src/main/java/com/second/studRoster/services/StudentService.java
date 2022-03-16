package com.second.studRoster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.studRoster.Repositories.StudentRepository; 
import com.second.studRoster.models.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	
	//Get All Student
	public List<Student> getAllStudent(){
		return this.studentRepo.findAll();
	}
	
	// Create Student
	public Student create(Student student) {
		return studentRepo.save(student);
	}
	
	//update Student
	
	
	// Delete Student
	public void deleteStudent(Long id) {
		this.studentRepo.deleteById(id);
	}
	
//	public Student addStudent(Long studentId,Lesson lesson) {
//		
//		Student mystudent = this.getById(studentId);
//		List<Student> myStudent = mystudent.getLesson();
//		myStudent.add(lesson);
//		
//		return studentRepo.save(mystudent);
//	}
//	
	
	
	
}
