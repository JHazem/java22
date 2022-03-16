package com.second.productCategory.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.second.productCategory.models.Category;
import com.second.productCategory.models.Product;
import com.second.productCategory.repositories.ProductRepository;

@Service
public class ProductService {

	//@Autowired
	private ProductRepository productRepo;
	
	//4-1
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	//4-2   List all the Product
	public List<Product> allProducts(){
		return productRepo.findAll();
	}
	
	//4-3 retrieves a Product
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	} 
	
	 //4-4    creates a Product
		public Product creatProduct(Product p) {
			return productRepo.save(p);
		}
	
		public Product saveProduct(@Valid Product product) {
			 
			return productRepo.save(product);
		}

		// cam
		public void addCategory(Product product, Category c) {
			c.getProducts().add(product);
			productRepo.save(product);
		}
	
	
	
}
