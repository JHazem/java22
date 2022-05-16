package com.second.virtualSchool.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.virtualSchool.models.Subject;

public interface SubjectRepository  extends CrudRepository<Subject, Long> {

	List<Subject> findAll();
	List<Subject> findBySubjectNameContaining(String SubjectName);
	//List<Subject> findByCityContaining(String city);

}
