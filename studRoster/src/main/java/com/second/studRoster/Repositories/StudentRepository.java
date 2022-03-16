package com.second.studRoster.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.studRoster.models.Student;

public interface StudentRepository extends CrudRepository<Student,Long>{

	List<Student> findAll();
}
 
