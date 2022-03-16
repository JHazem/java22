package com.second.pManager.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 

@Entity
@Table(name="projects")
public class Project {
		
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String title;
	 private String description;
	 private String teamLead;
	 private String dueDate;
	 
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
 
	 @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="user_id")
	    private User user;
	    
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(  name = "joined_projects", 
			     joinColumns = @JoinColumn(name = "project_id"), 
			     inverseJoinColumns = @JoinColumn(name = "user_id"))
	 
	 
	 private List<User> joint;
	 
	 public Project() { 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
  
	public List<User> getJoint() {
		return joint;
	}

	public void setJoint(List<User> joint) {
		this.joint = joint;
	}

	 

 

}


