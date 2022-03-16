package com.second.bookClub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
    private String name; //match2
     
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
   

    //p
    public User() {}
    

	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Book> books;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

    
 
}
