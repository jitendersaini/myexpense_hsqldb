/**
 * 
 */
package com.expense.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author j.saini
 * 
 */
public class MyExpenseHibernateSessionFactory {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {		
		return sessionFactory.getCurrentSession();
	}

}
