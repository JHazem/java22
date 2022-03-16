package com.second.tvshows.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.tvshows.models.TvShow;
 

public interface TvShowRepository extends CrudRepository<TvShow, Long>{

	List<TvShow> findAll();
}
