/**
 * 
 */
package com.expense.dao;

import java.util.List;

import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Expense;
import com.expense.hibernate.domains.Notification;
import com.expense.hibernate.domains.PaymentMode;
import com.expense.hibernate.domains.Users;

/**
 * @author j.saini
 *
 */
public interface DataDAO {

	List<Budget> findAllBudget();

	List<Category> findAllCategories();

	List<Expense> findAllExpense();

	List<Notification> findAllNotification();

	List<PaymentMode> findAllPaymentMode();

	List<Users> findAllUsers();

}
