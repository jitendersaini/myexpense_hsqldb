/**
 * 
 */
package com.expense.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.ExpenseDAO;
import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Expense;
import com.expense.util.AppUtils;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class ExpenseDAOImpl extends MyExpenseHibernateSessionFactory implements
		ExpenseDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<Expense> isCategoryMapped(String id) {

		List<Expense> list = getSession()
				.createQuery("from Expense where category.id in (:catids)")
				.setParameterList("catids",
						AppUtils.convertToLongArray(id.split(","))).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Expense isCategoryIdMapped(Long id) {
		List<Expense> list = getSession()
				.createQuery("from Expense where category.id = ?")
				.setParameter(0, id).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Expense isPaymentModeIdMapped(Long id) {
		List<Expense> list = getSession()
				.createQuery("from Expense where paymentMode.id = ?")
				.setParameter(0, id).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Budget> getBudget(String userid, int month, int year) {
		List<Budget> list = getSession()
				.createQuery(
						"from Budget budget where budget.usersByCreatedBy.id  in (:userids) and month = :month and year = :year")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).setParameter("month", month)
				.setParameter("year", year).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Budget> getMonYrs(String userid) {
		List<Budget> list = getSession()
				.createQuery(
						"from Budget budget where budget.usersByCreatedBy.id  in (:userids) order by month desc, year desc")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveBudget(Budget budget, String userid) {
		Session session = getSession();
		List<Budget> list = session
				.createQuery(
						"from Budget budget where budget.usersByCreatedBy.id  in (:userids) and month = :month and year = :year")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(",")))
				.setParameter("month", budget.getMonth())
				.setParameter("year", budget.getYear()).list();
		if (list.isEmpty()) {
			session.save(budget);
		} else {
			Budget budg = list.get(0);
			budg.setValue(budget.getValue());
			budg.setUsersByCreatedBy(budget.getUsersByCreatedBy());
			budg.setUsersByModifiedBy(budget.getUsersByModifiedBy());

			session.saveOrUpdate(budg);
		}
	}

	@Override
	public void save(Expense expense) {
		getSession().saveOrUpdate(expense);
	}

	@Override
	public void saveMultiple(List<Expense> mainList) {
		Session session = getSession();
		for (Expense expense : mainList) {
			session.save(expense);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expense> getAllExpense(String userid, Date begin, Date end) {
		List<Expense> list = getSession()
				.createQuery(
						"from Expense exp where exp.usersByCreatedBy.id  in (:userids) and  expenseDate BETWEEN :begin AND :end order by expenseDate asc")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).setParameter("end", end)
				.setParameter("begin", begin).list();
		return list;
	}

	@Override
	public void remove(String ids) {
		getSession()
				.createQuery("delete from Expense where id in (:ids)")
				.setParameterList("ids",
						AppUtils.convertToLongArray(ids.split(",")))
				.executeUpdate();
	}

}
