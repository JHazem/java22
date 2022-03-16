package com.second.pc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//...
@Entity
@Table(name="products")
public class Product {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 private String description;
 private float price;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 @OneToMany(mappedBy="product", fetch = FetchType.LAZY)
 @JsonIgnore
 private List<CategoryProduct> categoriesProducts;
 
 public Product() {
     
 }


}

 
