/**
 * 
 */
package com.expense.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.PayModeDAO;
import com.expense.hibernate.domains.Expense;
import com.expense.hibernate.domains.PaymentMode;
import com.expense.util.AppUtils;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class PayModeDAOImpl extends MyExpenseHibernateSessionFactory implements
		PayModeDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentMode> getAllPaymentModes(String userid) {
		List<PaymentMode> list = getSession()
				.createQuery(
						"from PaymentMode pm where pm.usersByCreatedBy.id  in (:userids)")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).list();

		return list;
	}

	@Override
	public void save(PaymentMode paymentMode) {
		getSession().saveOrUpdate(paymentMode);
	}

	@Override
	public void saveMultiple(List<PaymentMode> mainList) {
		Session session = getSession();
		for (PaymentMode paymentMode : mainList) {
			session.save(paymentMode);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expense> isPaymentModeMapped(String id) {
		return getSession()
				.createQuery("from Expense where paymentMode.id in (:ids)")
				.setParameterList("ids",
						AppUtils.convertToLongArray(id.split(","))).list();
	}

	@Override
	public void remove(String ids) {
		getSession()
				.createQuery("delete from PaymentMode where id in (:ids)")
				.setParameterList("ids",
						AppUtils.convertToLongArray(ids.split(",")))
				.executeUpdate();
	}
}
