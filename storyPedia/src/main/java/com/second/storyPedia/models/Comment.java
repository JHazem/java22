package com.second.storyPedia.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String comment;
	
	 @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="story_id")
	    private Story story;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user; // change  
	    
		public Comment() {
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
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
		public Story getStory() {
			return story;
		}
		public void setStory(Story story) {
			this.story = story;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}

	 
}
