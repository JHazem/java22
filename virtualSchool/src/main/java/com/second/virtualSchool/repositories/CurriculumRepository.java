package com.second.virtualSchool.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.virtualSchool.models.Curriculum;

public interface CurriculumRepository extends CrudRepository<Curriculum, Long> {

	List<Curriculum> findAll();

}
