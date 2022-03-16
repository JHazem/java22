package com.second.saveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.second.saveTravels.models.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
	

}
