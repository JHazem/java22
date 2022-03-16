package com.second.pManager.models;

import java.util.Date;

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

//@Entity
//@Table(name="projects")
//public class Task {
//
//
//	 @Id
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
//	 private Long id;
//	 private String task;
//	 private String namdOfadd;
//	  
//	 
//	 @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name="task_id")
//	    private User taskuser;
//	    
//	 @ManyToMany(fetch = FetchType.LAZY)
//	 @JoinTable(  name = "joined_projects", 
//			     joinColumns = @JoinColumn(name = "project_id"), 
//			     inverseJoinColumns = @JoinColumn(name = "task_id"))
//	 
//	 
//	 @Column(updatable=false)
//	 private Date createdAt;
//	 private Date updatedAt;
//	  
//	 
//	 
	 
	 
	 
