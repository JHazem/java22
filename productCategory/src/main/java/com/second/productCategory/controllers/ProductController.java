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
public class ProductController {

	@Autowired
	private ProductService productServ;
	
	@Autowired
	private CategoryService categoryServ;
	
//	public void productService(ProductService productServ, CategoryService categoryServ) {
//		this.categoryServ = categoryServ;
//		this.productServ = productServ;
//	}
	
		//1 
		@GetMapping("/products/new")
		public String newProduct(@ModelAttribute("addNewProduct") Product product) {
			return "newproduct.jsp";
 		}
	
		
		//2  CODE TO MAKE A NEW category AND SAVE TO THE DB  1
		@PostMapping("/products/new")
		public String addProduct(@Valid @ModelAttribute("addNewProduct") Product product,
								 	BindingResult result) {
			if(result.hasErrors()) {
				return "newproduct.jsp";
			}
			else {
				Product thisproduct =productServ.creatProduct(product);
				Long id =thisproduct.getId();
				return "redirect:/products/" + id ;
			}
		}
		
		
		//3    p/2
		@GetMapping("/products/{id}")
		public String showProduct( Model model,
							@PathVariable("id") Long id) {
			Product product = productServ.findProduct(id);
			
			model.addAttribute("product", product);
			model.addAttribute("mycategories", product.getCategories());
			model.addAttribute("categories", categoryServ.allCategories());
			return "showproduct.jsp";
		}
		
		@PostMapping("/products/{id}")
		public String addCategory(  @PathVariable("id") Long id,
									@RequestParam("category")Long idcat) {
			Category thisCategory = categoryServ.findCategory(idcat);
			Product thisProduct = productServ.findProduct(id);
			
			List<Category> categories = thisProduct.getCategories();
			productServ.addCategory(thisProduct, thisCategory);	
			return "redirect:/products/{id}";
		}
		
		
		
	 
	
}
