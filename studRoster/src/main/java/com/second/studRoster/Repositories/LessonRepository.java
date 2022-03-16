package com.second.studRoster.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.studRoster.models.Lesson;

public interface LessonRepository extends CrudRepository<Lesson,Long>{

	List<Lesson> findAll();
}
