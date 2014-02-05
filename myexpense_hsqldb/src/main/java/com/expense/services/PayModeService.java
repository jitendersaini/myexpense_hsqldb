/**
 * 
 */
package com.expense.services;

import java.util.List;

import com.expense.hibernate.domains.Expense;
import com.expense.hibernate.domains.PaymentMode;
import com.expense.models.PaymentModeModal;


/**
 * @author j.saini
 *
 */
public interface PayModeService {

	List<PaymentMode> getAllPaymentModes(String userid);

	void save(PaymentMode paymentMode);

	void saveMultiple(PaymentModeModal paymentModeModal, Long userid);

	List<Expense> isPaymentModeMapped(String id);

	void remove(String id);
}
