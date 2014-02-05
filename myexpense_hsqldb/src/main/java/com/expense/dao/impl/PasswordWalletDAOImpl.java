/**
 * 
 */
package com.expense.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.PasswordWalletDAO;
import com.expense.hibernate.domains.PasswordWallet;
import com.expense.hibernate.domains.SecurityQA;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class PasswordWalletDAOImpl extends MyExpenseHibernateSessionFactory
		implements PasswordWalletDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<PasswordWallet> getAllEnteries(Long userid) {
		return getSession()
				.createQuery(
						"from PasswordWallet where usersByCreatedBy.id = :userid")
				.setParameter("userid", userid).list();
	}

	@Override
	public void saveMultiple(List<PasswordWallet> mainList) {
		Session session = getSession();
		for (PasswordWallet passwordWallet : mainList) {
			session.save(passwordWallet);
		}
	}

	@Override
	public void saveQuestAns(List<SecurityQA> mainList) {
		Session session = getSession();
		for (SecurityQA securityQA : mainList) {
			session.save(securityQA);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PasswordWallet> retrievePassword(Long id) {
		return getSession().createQuery("from PasswordWallet where id = :id")
				.setParameter("id", id).list();
	}

}
