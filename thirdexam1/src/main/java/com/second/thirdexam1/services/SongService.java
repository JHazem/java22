package com.second.thirdexam1.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.thirdexam1.models.Song; 
import com.second.thirdexam1.repositories.SongRepository; 

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;
	
	 

    //4-2  returns all the bundler
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	

    //Find user by id
	public Song findById(Long id) {
		
		return songRepository.findById(id).orElse(null);
	}
 
    //4-3 retrieves a song
    public Song findSong(Long id) {
    	
        Optional<Song> optionalSong = songRepository.findById(id);
        
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } 
        else {
            return null;
        } 
    }
	
    

	  //4-4 creates a song
	public Song createSong(Song song) {
		return songRepository.save(song);
	}
	 
	public Song updateSong(@Valid Song song) {
	
		return songRepository.save(song);
	}
		
		//4-5 delete
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	

	
	
}
