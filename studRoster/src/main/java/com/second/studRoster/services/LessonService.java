package com.second.studRoster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.second.studRoster.Repositories.LessonRepository;
import com.second.studRoster.models.Lesson; 

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepo;
	
	// Get All Lessons
	public List<Lesson> getAllLesson(){
		return this.lessonRepo.findAll();
				
	}
	
	// Create Lesson
	public Lesson create(Lesson lesson) {
		return lessonRepo.save(lesson);
	}
	
	
	// Update Lesson
	
	//Delete Lesson
	public void deleteLesson(Long id) {
		this.lessonRepo.deleteById(id);
	}
	
//	public Lesson addStudent(Long lessonId,Student student) {
//		
//		Lesson mylesson = this.getById(lessonId);
//		List<Student> myStudent = mylesson.getStudents();
//		myStudent.add(student);
//		
//		return lessonRepo.save(mylesson);
//	}
//
//	private Lesson getById(Long lessonId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
