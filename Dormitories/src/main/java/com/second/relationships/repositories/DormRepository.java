package com.second.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.relationships.models.Dormitory;

public interface DormRepository extends CrudRepository<Dormitory,Long>{

	List<Dormitory> findAll();
}
