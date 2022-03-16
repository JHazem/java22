package com.second.thirdexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.thirdexam.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{

	List<Song> findAll();
}
