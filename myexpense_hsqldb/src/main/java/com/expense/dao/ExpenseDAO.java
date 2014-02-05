/**
 * 
 */
package com.expense.dao;

import java.util.Date;
import java.util.List;

import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Expense;

/**
 * @author j.saini
 * 
 */
public interface ExpenseDAO {

	List<Expense> isCategoryMapped(String id);

	Expense isCategoryIdMapped(Long id);

	Expense isPaymentModeIdMapped(Long id);

	List<Budget> getBudget(String userid, int month, int year);

	List<Budget> getMonYrs(String userid);

	void saveBudget(Budget budget, String userid);

	void save(Expense expense);

	void saveMultiple(List<Expense> mainList);

	List<Expense> getAllExpense(String userid, Date begin, Date end);

	void remove(String ids);
}
