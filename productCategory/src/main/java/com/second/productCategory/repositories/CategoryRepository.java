package com.second.productCategory.repositories;

import java.util.List; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.productCategory.models.Category;
import com.second.productCategory.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	 
    List<Category> findAllByProducts(Product product);
    
     
    List<Category> findByProductsNotContains(Product product);
    
    
    List<Category> findAll();
    
    
}
