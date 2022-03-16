package com.second.productCategory.services;

import java.util.List;
import java.util.Optional; 
import javax.validation.Valid; 
import org.springframework.stereotype.Service; 
import com.second.productCategory.models.Category;
import com.second.productCategory.models.Product;
import com.second.productCategory.repositories.CategoryRepository;

@Service
public class CategoryService {

	//@Autowired
	private CategoryRepository categoryRepo;
	
	//4-1
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}
	
	//4-2   List all the Category
//	public List<Category> allProduct(){
//		return (List<Category>) categoryRepo.findAll();
//	}
	
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	//4-3 retrieves a Category
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}
	}
	 
	 //4-4    creates a Category
		public Category creatCategory(Category c) {
			return categoryRepo.save(c);
		}
	
		public Category saveCategory(@Valid Category category) {
			 
			return categoryRepo.save(category);
		}
	
		// cam
		public void addProduct(Product p, Category category) {
			p.getCategories().add(category);
			categoryRepo.save(category);
		}
	
		
		
		
		
}
