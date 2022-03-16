package com.second.saveTravels.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.second.saveTravels.models.Expense;
import com.second.saveTravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService expService;
	
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	

	
	@GetMapping("/expenses")
	public String indexExpense(Model model, @ModelAttribute("newExpense") Expense expense) {
		
		List<Expense> expenses=expService.allExpenses();
		
		model.addAttribute("expenses" ,expenses);
		return "index.jsp";
	}

	
	//show Expense detail
	@GetMapping("/expenses/{id}")
	public String showPage( Model model,
							@PathVariable("id") Long id) {
		
		  Expense expense = expService.findExpense(id);
		  
		  model.addAttribute("expense", expense);
		  
		return "show.jsp";
	}
	

    // add new expense
	  @PostMapping("/expenses/new")
	  public String createNew(@Valid @ModelAttribute("newExpense") Expense expense,
			  					BindingResult result)  {

	  	if(result.hasErrors()) {
	  		//return "redirect:/expenses";
	  		return "edit.jsp";
	  	}
	  	
	  		expService.createExpense(expense);
	    
	  		return "redirect:/expenses";
	  }

    

	  //Edit and Update
//	   @GetMapping("/expenses/{id}/edit")
//	   public String edit(@PathVariable("id") Long id, Model model) {
//		   Expense expense = expService.findExpense(id);
//	       model.addAttribute("expense", expense);
//	       return "edit.jsp";
//	   }
	   
	  //5  edit
	   @GetMapping("/expenses/edit/{id}")
	   public String editexp(@PathVariable("id") Long id, Model model) {
		   Expense expense = expService.findExpense(id);
		   model.addAttribute("editExpense", expense);
		   return "edit.jsp";
	   }
	    
	   //6  edit expense or update
	   @PutMapping("/expenses/{id}")
	   public String update(@Valid @ModelAttribute("editExpense") Expense expense,
						   BindingResult result) {
		   
	       if (result.hasErrors()) {
	           return "edit.jsp";
	       } else {
	    	   
	           expService.updateExpense(expense);
	           return "redirect:/expenses";
	       }
	   }
	   
		 //Delete
	   
		 @GetMapping("/expenses/delete/{id}")
		  public String destroy(@PathVariable("id") Long id) {
		      expService.deleteExpense(id);
		      return "redirect:/expenses";
		  }
		 
		   //details
//	       @GetMapping("/expenses/details/{id}")
//	       public String details(@PathVariable("id") Long id, Model model) {
//	    	   model.addAttribute("expense", expService.findExpense(id));
//	           return "redirect:/expenses";
//	       }
		 
}













