/**
 * 
 */
package com.expense.services;

import java.util.List;
import java.util.Map;

import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Expense;
import com.expense.models.Report;
import com.expense.models.ReportData;

/**
 * @author j.saini
 * 
 */
public interface ReportService {

	List<ReportData> getAllExpense(List<Expense> list);

	Map<Integer, Map<Integer, List<Expense>>> getExpense4Report(String string,
			Report report);

	List<Budget> getBudgets4Report(String userid);

}
