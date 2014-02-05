/**
 * 
 */
package com.expense.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.ChartDAO;
import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Expense;
import com.expense.util.AppConstants;
import com.expense.util.AppUtils;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class ChartDAOImpl extends MyExpenseHibernateSessionFactory implements
		ChartDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, List<Expense>> getDataForYear(String userid,
			Integer year) {

		Map<Integer, List<Expense>> map = new HashMap<Integer, List<Expense>>();

		Calendar calendar1;
		Calendar calendar2;

		String[] arrMonth = AppConstants.MONTHS_ARRAY;
		// Criteria c;

		for (int i = 0; i < arrMonth.length; i++) {
			calendar1 = new GregorianCalendar(year, i, Calendar.DATE);
			calendar1.set(Calendar.DATE,
					calendar1.getActualMinimum(Calendar.DATE));

			calendar2 = new GregorianCalendar(year, i, Calendar.DATE);
			calendar2.set(Calendar.DATE,
					calendar2.getActualMaximum(Calendar.DATE));

			List<Expense> l = getSession()
					.createQuery(
							"from Expense where expenseDate > ? and expenseDate < ?")
					.setParameter(0, calendar1.getTime())
					.setParameter(1, calendar2.getTime()).list();
			if (null != l && !l.isEmpty()) {
				map.put(i, l);
			}

			/*
			 * c = new Criteria().andOperator(
			 * Criteria.where("expenseDate").gte(calendar1.getTime()),
			 * Criteria.where("expenseDate").lte(calendar2.getTime())); c =
			 * c.and("userid").in((Object[])userid.split(",")); Query query =
			 * new Query(c); List<Expense> l = mongoTemplate.find(query,
			 * Expense.class); if (null != l && !l.isEmpty()) { map.put(i, l); }
			 */
		}

		return map;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Integer, Double> getBudgetsForYear(String userid, Integer year) {
		/*
		 * Query query = new
		 * Query(Criteria.where("userid").in((Object[])userid.split
		 * (",")).and("year") .is(year)); List<Budget> list =
		 * mongoTemplate.find(query, Budget.class); Map<Integer, Double> map =
		 * new HashMap<Integer, Double>(); for (Budget budget : list) {
		 * map.put(budget.getMonth(), budget.getValue()); }
		 */

		// List<Budget> list =
		// getSession().createQuery("from Budget budg where budg.usersByCreatedBy.id in ? and year = ?").setParameterList(0,
		// l).setParameter(1, year).list();
		List<Budget> list = getSession()
				.createQuery(
						"from Budget budg where budg.usersByCreatedBy.id  in (:userids) and year = :year")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).setParameter("year", year).list();

		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for (Budget budget : list) {
			map.put(budget.getMonth(), budget.getValue());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getBudgetsForUser(String userid) {
		/*
		 * Query query = new
		 * Query(Criteria.where("userid").in((Object[])userid.split(",")));
		 * query.sort().on("year", Order.ASCENDING); List<Budget> list =
		 * mongoTemplate.find(query, Budget.class); Set<Integer> set = new
		 * TreeSet<Integer>(); for (Budget budget : list) {
		 * set.add(budget.getYear()); }
		 */
		List<Budget> list = getSession()
				.createQuery(
						"from Budget where usersByCreatedBy.id in (:userids) order by year")
				.setParameterList("userids",
						AppUtils.convertToLongArray(userid.split(","))).list();
		Set<Integer> set = new TreeSet<Integer>();
		for (Budget budget : list) {
			set.add(budget.getYear());
		}
		return new ArrayList<Integer>(set);

	}

}
