package com.second.thirdexam1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.thirdexam1.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{

	List<Song> findAll();
}
