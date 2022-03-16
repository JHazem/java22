package com.second.saveTravels.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.saveTravels.models.Expense;
import com.second.saveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expRepository;
	
	//4-2  returns all the expense
	public List<Expense> allExpenses(){
		return expRepository.findAll();
	}
	
    //4-4  creates a expense
    public Expense createExpense(Expense e) {
        return expRepository.save(e);
    }
    
    public Expense update(Expense e) {
        return expRepository.save(e);
    }

    // retrieves
    public Expense findExpense(Long id) {
    	
        Optional<Expense> optionalExpense = expRepository.findById(id);
        
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
                 
        } else {
            return null;
        } 
    }
  //4-5      delete
	public void deleteExpense(Long id) {
		expRepository.deleteById(id);
	}
	

	
	//4-7  
	public void updateExpense(Expense exp) {
		// TODO Auto-generated method stub
		expRepository.save(exp);
	}
}
