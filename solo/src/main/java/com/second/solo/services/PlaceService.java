package com.second.solo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.solo.models.Place;
import com.second.solo.models.User;
import com.second.solo.repositories.PlaceRepository; 

@Service
public class PlaceService {


	@Autowired
	private PlaceRepository placeRepo;
	
 
	
	//4-2   List all the place
	public List<Place> allPlaces(){
		return placeRepo.findAll();
	}
	
    //Find user by id
	public Place findById(Long id) {
		
		return placeRepo.findById(id).orElse(null);
	}

	//4-3 retrieves a place
	public Place findPlace(Long id) {
		
		Optional<Place> optionalPlace = placeRepo.findById(id);
		
		if(optionalPlace.isPresent()) {
			return optionalPlace.get();
		}
		else {
			return null;
		}
	} 
	
	 //4-4    creates a Place
		public Place creatPlace(Place p) {
			return placeRepo.save(p);
		}
	
		public Place savePlace(@Valid Place place) {
			 
			return placeRepo.save(place);
		}

		// cam
		public void addUser(Place place, User k) {
			k.getPlaces().add(place);
			placeRepo.save(place);
		}
	
		//4-5 delete
		public void deletePlace(Long id) {
			placeRepo.deleteById(id);
		}
		 
 
		//Search 
		 
		public List<Place> findUserPlace(String txt) { // is not searching by user; it is getting results for ALL users with this place
			List<Place> placeName = placeRepo.findByPlaceNameContaining(txt); 
			//List<Place> city = placeRepo.findByCityContaining(txt); 
			
			return placeName;
		}
		
		
		  
		
	
}
