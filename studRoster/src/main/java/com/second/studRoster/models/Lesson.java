package com.second.studRoster.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="lessons")
public class Lesson {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String lessonName;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(  name = "students_lessons", 
			     joinColumns = @JoinColumn(name = "lesson_id"), 
			     inverseJoinColumns = @JoinColumn(name = "student_id"))

	 private List<Student> students;
	 
	 public Lesson() {
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setClassName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	 
	 
}
