package com.second.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.exam.models.Bundler; 
 

public interface BundlerRepository extends CrudRepository<Bundler, Long>{

	List<Bundler> findAll();
}
