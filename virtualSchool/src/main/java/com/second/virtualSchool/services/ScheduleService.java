package com.second.virtualSchool.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.virtualSchool.models.Schedule;
import com.second.virtualSchool.models.User;
import com.second.virtualSchool.repositories.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepo;
	
	//4-2   List all the Story
	 	public List<Schedule> allSchedules(){
	 		return scheduleRepo.findAll();
		}
		
	    //Find user by id
		public Schedule findById(Long id) {
			
			return scheduleRepo.findById(id).orElse(null);
		}
		
		//4-3 retrieves a Schedule
		public Schedule findSchedule(Long scheduleId) {
			Optional<Schedule> optionalSchedule = scheduleRepo.findById(scheduleId);
			
			if(optionalSchedule.isPresent()) {
				return optionalSchedule.get();
			}
			else {
				return null;
			}
		} 
	
		 //4-4    creates a Schedule
			public Schedule creatSchedule(Schedule p) {
				return scheduleRepo.save(p);
			}
		
			public Schedule saveSchedule(@Valid Schedule schedule) {
				 
				return scheduleRepo.save(schedule);
			}

			// cam
			public void addUser(Schedule schedule, User c) {
				c.getSchedules().add(schedule);
				scheduleRepo.save(schedule);
			}
		
			//delete
			public void deleteSchedule(Long id) {
				scheduleRepo.deleteById(id);
			}
	
			//Search 
			 
			public List<Schedule> findUserSchedule(Long userId, String txt) {
				 return scheduleRepo.findByDayContaining(txt);
			}
	
	
}
