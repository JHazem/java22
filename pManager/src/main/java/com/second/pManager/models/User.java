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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	 //p
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //p
    @NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="First Name must be between 3 and 30 characters")
    private String firstName; //match2
     
    @NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
    private String lastName; //match2
     
	//p
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    //p
    @NotEmpty(message="Password is required!")
    @Size(min=4, max=200, message="Password must be between 8 and 128 characters")
    private String password;
    //p
    @Transient  
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=4, max=200, message="Confirm Password must be between 8 and 128 characters")
    private String passCodeConfirm;
   
    @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 				

	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable( name = "joined_projects",
			 joinColumns = @JoinColumn(name = "user_id"), 
		     inverseJoinColumns = @JoinColumn(name = "project_id"))

	private List<Project> joinedProjects;
	
	
	  //p
    public User() {}
     

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
     
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassCodeConfirm() {
		return passCodeConfirm;
	}
	public void setPassCodeConfirm(String passCodeConfirm) {
		this.passCodeConfirm = passCodeConfirm;
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
	public List<Project> getProjects() {
		return getProjects();
	}
	public void setProjects(List<Project> projects) {
		this.joinedProjects = projects;
	}

	public List<Project> getJoinedProjects() {
		return joinedProjects;
	}
	
	public void setJoinedProjects(List<Project> joinedProjects) {
		this.joinedProjects = joinedProjects;
	}


  

    
    
     
 
}
