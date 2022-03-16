package com.second.testexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.testexam.models.BabyName;

public interface BabyNameRepository extends CrudRepository<BabyName, Long>{

	List<BabyName> findAll();
}
