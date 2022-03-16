package com.second.solo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.solo.models.Place; 

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long>{
 
	
 	 
	List<Place> findAll();
	List<Place> findByPlaceNameContaining(String placeName);
	List<Place> findByCityContaining(String city);

 
}
