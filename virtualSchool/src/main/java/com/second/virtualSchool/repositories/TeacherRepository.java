package com.second.virtualSchool.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.virtualSchool.models.Teacher;

public interface TeacherRepository   extends CrudRepository<Teacher, Long> {

	List<Teacher> findAll();
	List<Teacher> findByFirstNameContaining(String firstName);
}
