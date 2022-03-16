package com.second.productCategory.repositories;

import java.util.List; 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.second.productCategory.models.Category;
import com.second.productCategory.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    List<Product> findAllByCategories(Category category);
    
    
    List<Product> findByCategoriesNotContains(Category category);


	List<Product> findAll();


//	Optional<Product> findById(Long id);
//
//
//	Product save(Product p);


}
