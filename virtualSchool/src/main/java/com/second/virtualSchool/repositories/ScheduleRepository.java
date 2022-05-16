package com.second.virtualSchool.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.virtualSchool.models.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> { 
	List<Schedule> findAll();
	List<Schedule> findByDayContaining(String firstName);

}
