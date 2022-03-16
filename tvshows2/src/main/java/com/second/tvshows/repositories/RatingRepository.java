package com.second.tvshows.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.tvshows.models.Rating;
@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{

}
