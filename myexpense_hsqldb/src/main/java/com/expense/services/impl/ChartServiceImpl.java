/**
 * 
 */
package com.expense.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.ChartDAO;
import com.expense.hibernate.domains.Expense;
import com.expense.services.ChartService;

/**
 * @author j.saini
 *
 */
@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	ChartDAO chartDao;

	@Override
	public Map<Integer, List<Expense>> getDataForYear(String userid,
			Integer year) {
		// TODO Auto-generated method stub
		return chartDao.getDataForYear(userid,year);
	}

	@Override
	public Map<Integer, Double> getBudgetsForYear(String userid, Integer year) {
		// TODO Auto-generated method stub
		return chartDao.getBudgetsForYear(userid,year);
	}

	@Override
	public List<Integer> getBudgetsForUser(String userid) {
		// TODO Auto-generated method stub
		return chartDao.getBudgetsForUser(userid);
	}
	
}
