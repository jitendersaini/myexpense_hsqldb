/**
 * 
 */
package com.expense.dao;

import java.util.List;

import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Expense;
import com.expense.models.Report;

/**
 * @author j.saini
 * 
 */
public interface ReportDAO {

	List<Expense> getExpense4Report(String userid, Report report, int year,
			int month);

	List<Budget> getBudgets4Report(String userid);
}
