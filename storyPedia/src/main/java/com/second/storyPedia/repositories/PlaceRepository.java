package com.second.storyPedia.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.storyPedia.models.Place; 

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long>{
 
	
 	 
	List<Place> findAll();
	List<Place> findByPlaceNameContaining(String placeName);
	List<Place> findByCityContaining(String city);

 
}
