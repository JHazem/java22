package com.second.thirdexam.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.thirdexam.models.Song;
import com.second.thirdexam.models.User;
import com.second.thirdexam.repositories.SongRepository;
import com.second.thirdexam.repositories.UserRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private UserRepository userRepository;
	

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
	
    

	  //4-4 creates a bundler
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
	
	//Like
	public void vote(Song song, User user) {
		user.getVotedFor().add(song);
		userRepository.save(user);
	}
	
	//UnLike
	
	public void unVote(Song song, User user) {
		user.getVotedFor().remove(song);
		userRepository.save(user);
	}
	
	
	
}
