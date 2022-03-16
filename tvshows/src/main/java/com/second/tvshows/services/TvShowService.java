package com.second.tvshows.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.tvshows.models.TvShow;
import com.second.tvshows.repositories.TvShowRepository;
 
@Service
public class TvShowService {
	
	@Autowired
	private TvShowRepository tvRepository;
	 
	
	
    //4-2  returns all the tv
	public List<TvShow> allTvShows() {
		return tvRepository.findAll();
	}
	

    //Find user by id
	public TvShow findById(Long id) {
		
		return tvRepository.findById(id).orElse(null);
	}
 
    //4-3 retrieves a tv
    public TvShow findTv(Long id) {
    	
        Optional<TvShow> optionalTvShow = tvRepository.findById(id);
        
        if(optionalTvShow.isPresent()) {
            return optionalTvShow.get();
        } 
        else {
            return null;
        } 
    }

	  //4-4 creates a tv
	public TvShow createTvShow(TvShow tv) {
		return tvRepository.save(tv);
	}
	 
	public TvShow updateTvShow(@Valid TvShow tv) {
	
		return tvRepository.save(tv);
	}
		
		//4-5 delete
	public void deleteTvShow(Long id) {
		tvRepository.deleteById(id);
	}
	
	

}
