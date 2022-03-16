package com.second.lookify.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.second.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify,Long>{
	List<Lookify> findAll();
}
