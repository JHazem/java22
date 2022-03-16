package com.second.pManager.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.pManager.models.Project;
import com.second.pManager.models.User;
import com.second.pManager.repositories.ProjectRepository;

 
@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;
	
	//4-1
	public ProjectService(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	//4-2   List all the Project
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	//4-3 retrieves a Project
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}
		else {
			return null;
		}
	} 
	
	 //4-4    creates a Project
		public Project creatProject(Project p) {
			return projectRepo.save(p);
		}
	
		public Project saveProject(@Valid Project project) {
			 
			return projectRepo.save(project);
		}

		// cam
		public void addUser(Project project, User c) {
			c.getProjects().add(project);
			projectRepo.save(project);
		}
		
		//delete
		public void deleteProject(Long id) {
			projectRepo.deleteById(id);
		}
		
		public List<Project> notjoin(User currentUser){
			return projectRepo.findAllByJointNotContains(currentUser);
		}

		public Project findById(Long id) {
			
			return projectRepo.findById(id).orElse(null);
		}
		
		public List<Project> join(User user){
			
			return projectRepo.findAllByJointContains(user);
		}
	
}
