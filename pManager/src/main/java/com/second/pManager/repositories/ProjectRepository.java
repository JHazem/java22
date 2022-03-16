package com.second.pManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.second.pManager.models.Project;
import com.second.pManager.models.User;

 
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

    List<Project> findAllByUser(User user);
    
    
    List<Project> findByUserIsNot(User user);
 
	List<Project> findAll();

	
	List<Project> findAllByJointNotContains(User user);
	List<Project> findAllByJointContains(User user);
//	Optional<Project> findById(Long id);
//
//
//	Project save(Project p);


}
