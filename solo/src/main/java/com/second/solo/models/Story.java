package com.second.solo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank; 
 

@Entity
@Table(name="stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="  Name is required!")
    @Column(unique=true)
    private String title;  
      
    @NotBlank(message="Must not be blank") 
    private String content;  
 
   
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_id")
	 private User user;
	    
	 // Mony to one link to place
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="place_id")
	 private Place myplace;  
	 
	 // Comment
	 @OneToMany(mappedBy="story", fetch = FetchType.LAZY)  
	 private List<Comment> comments;
 	 
 	 @PrePersist
 	 protected void onCreate(){
        this.createdAt = new Date();
 	 }
 	 
 	 @PreUpdate
 	 protected void onUpdate(){
        this.updatedAt = new Date();
 	 }
 	  
	 
	 public Story() { 
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Place getMyplace() {
		return myplace;
	}
	public void setMyplace(Place myplace) {
		this.myplace = myplace;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	 
   
	 
}
