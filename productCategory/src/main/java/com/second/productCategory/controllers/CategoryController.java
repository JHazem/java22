package com.second.productCategory.controllers;
 
import java.util.List;

import javax.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import com.second.productCategory.models.Category;
import com.second.productCategory.models.Product;
import com.second.productCategory.services.CategoryService;
import com.second.productCategory.services.ProductService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryServ;
	
	@Autowired
	private ProductService productServ;
	
	//4-1
//	public void categoryService(CategoryService categoryServ, ProductService productServ) {
//		this.productServ = productServ;
//		this.categoryServ = categoryServ;
//	}
	
	//1 
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("addNewCategory") Category category) {
		return "newcategory.jsp";
	}
	
	
	//2 CODE TO MAKE A NEW category AND SAVE TO THE DB
	@PostMapping("/categories/new")
	public String addCategory( @Valid @ModelAttribute("addNewCategory") Category category,
						    	 BindingResult result) {
		if(result.hasErrors()) {
			return "newcategory.jsp";
		}
		else {
			Category thiscategory = categoryServ.creatCategory(category);
			Long id = thiscategory.getId();
			return "redirect:/categories/" +id ; 
		}
	}
	
	
	//3    p/2
	@GetMapping("/categories/{id}")
	public String showCategory( Model model,
							@PathVariable("id") Long id) {
		Category category = categoryServ.findCategory(id);
		
		model.addAttribute("category", category);
		model.addAttribute("myproducts",category.getProducts());
		model.addAttribute("products", productServ.allProducts());
		return "showcategory.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long id,
							 @RequestParam("product")Long idprod) {
		Product findProduct = productServ.findProduct(idprod);
		Category thisCategory = categoryServ.findCategory(id);
		
		List<Product> products = thisCategory.getProducts(); 
		categoryServ.addProduct(findProduct, thisCategory);
		return "redirect:/categories/{id}" ;
	}
	
	
	
 
	
}
	
 
