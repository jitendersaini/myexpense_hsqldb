/**
 * 
 */
package com.expense.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.ExpenseDAO;
import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Expense;
import com.expense.hibernate.domains.PaymentMode;
import com.expense.hibernate.domains.Users;
import com.expense.models.ExpenseModal;
import com.expense.services.ExpenseService;

/**
 * @author j.saini
 * 
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseDAO expenseDAO;

	@Override
	public List<Expense> isCategoryMapped(String id) {
		// TODO Auto-generated method stub
		return expenseDAO.isCategoryMapped(id);
	}

	@Override
	public Expense isCategoryIdMapped(Long id) {
		// TODO Auto-generated method stub
		return expenseDAO.isCategoryIdMapped(id);
	}

	@Override
	public Expense isPaymentModeIdMapped(Long id) {
		return expenseDAO.isPaymentModeIdMapped(id);
	}

	@Override
	public List<Budget> getBudget(String userid, int month, int year) {
		return expenseDAO.getBudget(userid, month, year);
	}

	@Override
	public List<Budget> getMonYrs(String userid) {
		return expenseDAO.getMonYrs(userid);
	}

	@Override
	public void saveBudget(Budget budget, String userid) {
		expenseDAO.saveBudget(budget, userid);
	}

	@Override
	public void save(Expense expense) {
		if (expense.getId() == null) {
			expense.setCreatedDate(new Date());
		}
		expense.setModifiedDate(new Date());
		expenseDAO.save(expense);
	}

	@Override
	public void saveMultiple(ExpenseModal expenseList, String userid) {
		List<Expense> mainList = new ArrayList<Expense>();
		Expense expense;
		int i = 0;
		Users users = new Users();
		users.setId(Long.valueOf(userid));
		for (String title : expenseList.getExpenseTitle()) {
			expense = new Expense();
			expense.setExpenseTitle(title);
			expense.setCategory(new Category(Long.valueOf(expenseList
					.getCategoryid().get(i))));
			expense.setCreatedDate(new Date());
			expense.setExpenseDate(expenseList.getExpenseDate().get(i));
			expense.setExpenseValue(expenseList.getExpenseValue().get(i));
			expense.setModifiedDate(new Date());
			expense.setPaymentMode(new PaymentMode(Long.valueOf(expenseList
					.getPaidViaId().get(i))));
			expense.setUsersByCreatedBy(users);
			expense.setUsersByModifiedBy(users);

			mainList.add(expense);
			i++;
		}
		// category.setUsers(usersService.findById());
		expenseDAO.saveMultiple(mainList);
	}

	@Override
	public List<Expense> getAllExpense(String userid, Date begin, Date end) {
		return expenseDAO.getAllExpense(userid, begin, end);
	}

	@Override
	public void remove(String ids) {
		expenseDAO.remove(ids);
	}

}
