/**
 * 
 */
package com.expense.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.ReportDAO;
import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Expense;
import com.expense.models.Report;
import com.expense.util.AppUtils;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class ReportDAOImpl extends MyExpenseHibernateSessionFactory implements
		ReportDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Expense> getExpense4Report(String userid, Report report,
			int year, int month) {
		if (report.getFrom() == null && report.getTo() == null) {

			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH,
					calendar.getActualMinimum(Calendar.DAY_OF_MONTH) - 1);

			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(Calendar.DAY_OF_MONTH,
					calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));

			StringBuilder stbQueryBuilder = new StringBuilder();
			stbQueryBuilder
					.append("from Expense where expenseDate BETWEEN :date1 AND :date2 AND usersByCreatedBy.id  in (:userids)");

			if (report.getGrouping() == 1) {
				stbQueryBuilder
						.append("order by category.id asc, expenseDate desc");
				// query.sort().on("categoryid",
				// Order.ASCENDING).on("expenseDate", Order.DESCENDING);
			} else {
				stbQueryBuilder
						.append("order by paymentMode.paymentMode asc, expenseDate desc");

				// query.sort().on("paidVia", Order.ASCENDING).on("expenseDate",
				// Order.DESCENDING);
			}

			List<Expense> list = getSession()
					.createQuery(stbQueryBuilder.toString())
					.setParameterList(
							"userids",
							AppUtils.convertToLongArray(userid.toString()
									.split(",")))
					.setParameter("date1", calendar.getTime())
					.setParameter("date2", calendar1.getTime()).list();
			return list;

			/*
			 * Criteria c = new
			 * Criteria().andOperator(Criteria.where("expenseDate"
			 * ).gte(calendar.getTime()),
			 * Criteria.where("expenseDate").lte(calendar1.getTime())); c =
			 * c.and("userid").in((Object[])userid.split(","));
			 * 
			 * Query query = new Query(c); if(report.getGrouping()==1) {
			 * query.sort().on("categoryid", Order.ASCENDING).on("expenseDate",
			 * Order.DESCENDING); } else { query.sort().on("paidVia",
			 * Order.ASCENDING).on("expenseDate", Order.DESCENDING); }
			 */
			// Execute the query and find all matching entries
			// return mongoTemplate.find(query, Expense.class);

			/*
			 * return getSession() .createQuery(
			 * "from Expense where year(expenseDate) = year(current_date()) and month(expenseDate) = month(current_date()) and users.id=? order by year(expenseDate),month(expenseDate),category.id asc"
			 * ) .setParameter(0, userid).list();
			 */
		} else {
			/*
			 * return getSession() .createQuery(
			 * "from Expense where expenseDate > ? and expenseDate < ? and users.id=? order by year(expenseDate),month(expenseDate),category.id asc"
			 * ) .setParameter(0, report.getFrom()) .setParameter(1,
			 * report.getTo()).setParameter(2, userid) .list();
			 */

			StringBuilder stbQueryBuilder = new StringBuilder();
			stbQueryBuilder
					.append("from Expense where expenseDate BETWEEN :date1 AND :date2 AND usersByCreatedBy.id  in (:userids)");
			if (report.getGrouping() == 1) {
				stbQueryBuilder
						.append("order by category.id asc, expenseDate desc");
				// query.sort().on("categoryid",
				// Order.ASCENDING).on("expenseDate", Order.DESCENDING);
			} else {
				stbQueryBuilder
						.append("order by paymentMode.paymentMode asc, expenseDate desc");
				// query.sort().on("paidVia", Order.ASCENDING).on("expenseDate",
				// Order.DESCENDING);
			}
			/*
			 * Criteria c = new
			 * Criteria().andOperator(Criteria.where("expenseDate"
			 * ).gte(report.getFrom()),
			 * Criteria.where("expenseDate").lte(report.getTo())); c =
			 * c.and("userid").in((Object[])userid.split(","));
			 * 
			 * Query query = new Query(c); if(report.getGrouping()==1) {
			 * query.sort().on("categoryid", Order.ASCENDING).on("expenseDate",
			 * Order.DESCENDING); } else { query.sort().on("paidVia",
			 * Order.ASCENDING).on("expenseDate", Order.DESCENDING); }
			 */
			// Execute the query and find all matching entries
			// return mongoTemplate.find(query, Expense.class);
			List<Expense> list = getSession()
					.createQuery(stbQueryBuilder.toString())
					.setParameterList(
							"userids",
							AppUtils.convertToLongArray(userid.toString()
									.split(",")))
					.setParameter("date1", report.getFrom())
					.setParameter("date2", report.getTo()).list();

			return list;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Budget> getBudgets4Report(String userid) {
		// Query query = new
		// Query(Criteria.where("userid").in((Object[])userid.split(",")));
		return getSession()
				.createQuery(
						"from Budget where usersByCreatedBy.id  in (:userids)")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).list();
	}
}
