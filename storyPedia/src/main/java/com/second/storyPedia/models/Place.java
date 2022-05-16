package com.second.storyPedia.models;

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
@Table(name="places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="  Name is required!")
    @Column(unique=true) 
//    @Unique(message="The place already existing")
    private String placeName;  
    
    @NotBlank(message="  Name is required!")
    private String city;  
 
    
    @NotBlank(message="Must not be blank")
    private String content;  
  
    
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 

	 @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="user_id")
	 private User user;
	  
	 // One to many Link to story
	 @OneToMany(mappedBy="myplace", fetch = FetchType.LAZY)
	 private List<Story> stories;
	  

 	 @PrePersist
 	 protected void onCreate(){
        this.createdAt = new Date();
 	 }
 	 
 	 @PreUpdate
 	 protected void onUpdate(){
        this.updatedAt = new Date();
 	 }
	 
	 
	 public Place() { 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

 
    
    
}
