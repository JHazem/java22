package com.second.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.relationships.models.Student;

public interface StudentRepository extends CrudRepository<Student,Long>{

	List<Student> findAll();
}
