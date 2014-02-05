/**
 * 
 */
package com.expense.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.DataDAO;
import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Expense;
import com.expense.hibernate.domains.Notification;
import com.expense.hibernate.domains.PaymentMode;
import com.expense.hibernate.domains.Users;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class DataDAOImpl extends MyExpenseHibernateSessionFactory implements
		DataDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Budget> findAllBudget() {
		return (List<Budget>) getSession().createQuery("from Budget").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategories() {
		return (List<Category>) getSession().createQuery("from Category").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expense> findAllExpense() {
		return (List<Expense>) getSession().createQuery("from Expense").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> findAllNotification() {
		return (List<Notification>) getSession().createQuery(
				"from Notification").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentMode> findAllPaymentMode() {
		return (List<PaymentMode>) getSession().createQuery("from PaymentMode").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAllUsers() {
		return (List<Users>) getSession().createQuery("from Users").list();
	}

}
