/**
 * 
 */
package com.expense.dao;

import java.util.List;

import com.expense.hibernate.domains.Expense;
import com.expense.hibernate.domains.PaymentMode;



/**
 * @author j.saini
 *
 */
public interface PayModeDAO {

	List<PaymentMode> getAllPaymentModes(String userid);

	void save(PaymentMode paymentMode);	

	void saveMultiple(List<PaymentMode> mainList);

	List<Expense> isPaymentModeMapped(String id);

	void remove(String id);
}
