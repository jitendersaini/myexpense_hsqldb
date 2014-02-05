/**
 * 
 */
package com.expense.dao;

import java.util.List;
import java.util.Map;

import com.expense.hibernate.domains.Expense;

/**
 * @author j.saini
 *
 */
public interface ChartDAO {

	Map<Integer, List<Expense>> getDataForYear(String userid, Integer year);

	Map<Integer, Double> getBudgetsForYear(String userid, Integer year);
	
	public List<Integer> getBudgetsForUser(String userid);

}
