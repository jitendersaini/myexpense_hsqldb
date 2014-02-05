/**
 * 
 */
package com.expense.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.PayModeDAO;
import com.expense.hibernate.domains.Expense;
import com.expense.hibernate.domains.PaymentMode;
import com.expense.hibernate.domains.Users;
import com.expense.models.PaymentModeModal;
import com.expense.services.PayModeService;

/**
 * @author j.saini
 * 
 */
@Service
public class PayModeServiceImpl implements PayModeService {

	@Autowired
	PayModeDAO payModeDAO;

	@Override
	public List<PaymentMode> getAllPaymentModes(String userid) {
		// TODO Auto-generated method stub
		return payModeDAO.getAllPaymentModes(userid);
	}

	@Override
	public void save(PaymentMode paymentMode) {
		if (paymentMode.getId() == null) {
			paymentMode.setCreatedDate(new Date());
		}
		paymentMode.setModifiedDate(new Date());
		payModeDAO.save(paymentMode);

	}

	@Override
	public void saveMultiple(PaymentModeModal payModeList, Long userid) {
		List<PaymentMode> mainList = new ArrayList<PaymentMode>();
		PaymentMode paymentMode;
		int i = 0;
		Users users = new Users();
		users.setId(userid);
		for (String name : payModeList.getPaymentMode()) {
			paymentMode = new PaymentMode();
			paymentMode.setPaymentMode(name);
			paymentMode.setPaymentModeType((int) payModeList
					.getPaymentModeType().get(i));
			paymentMode.setCreatedDate(new Date());
			paymentMode.setId(null);
			paymentMode.setModifiedDate(new Date());
			paymentMode.setUsersByCreatedBy(users);
			paymentMode.setUsersByModifiedBy(users);
			mainList.add(paymentMode);
			i++;
		}
		// category.setUsers(usersService.findById());
		payModeDAO.saveMultiple(mainList);
	}

	@Override
	public List<Expense> isPaymentModeMapped(String id) {
		// TODO Auto-generated method stub
		return payModeDAO.isPaymentModeMapped(id);
	}

	@Override
	public void remove(String id) {
		payModeDAO.remove(id);
	}

}
