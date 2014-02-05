/**
 * 
 */
package com.expense.services;

import java.util.Date;
import java.util.List;

import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Expense;
import com.expense.models.ExpenseModal;

/**
 * @author j.saini
 * 
 */
public interface ExpenseService {

	List<Expense> isCategoryMapped(String id);

	Expense isCategoryIdMapped(Long id);

	Expense isPaymentModeIdMapped(Long id);

	List<Budget> getBudget(String userid, int month, int year);

	List<Budget> getMonYrs(String userid);

	void saveBudget(Budget budget, String userid);

	void save(Expense expense);

	void saveMultiple(ExpenseModal expense, String userid);

	List<Expense> getAllExpense(String userid, Date begin, Date end);

	void remove(String id);
}
