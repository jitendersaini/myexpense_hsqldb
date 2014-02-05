/**
 * 
 */
package com.expense.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.UsersDAO;
import com.expense.hibernate.domains.Users;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class UsersDAOImpl extends MyExpenseHibernateSessionFactory implements
		UsersDAO {

	@Override
	public String save(Users users) {
		if (null != users.getId()) {
			Users userstmp = getUserForEdit(users.getId());
			userstmp.setColorTheme(users.getColorTheme());
			userstmp.setName(users.getName());
			userstmp.setEmail(users.getEmail());
			userstmp.setModifiedDate(new Date());
			users = userstmp;
		} else {
			if (findByUserName(users.getUsername())) {
				return "username";
			} else if (findByEmail(users.getEmail())) {
				return "email";
			}
			Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
			users.setPassword(passwordEncoder.encodePassword(
					users.getPassword(), null));
			users.setCreatedDate(new Date());
			users.setModifiedDate(new Date());
		}

		getSession().save(users);
		return "save";
	}

	@SuppressWarnings("unchecked")
	private boolean findByUserName(String username) {
		List<Users> list = getSession()
				.createQuery("from Users where username = ?")
				.setParameter(0, username).list();
		return (list != null && list.size() == 0) ? false : true;
	}

	@SuppressWarnings("unchecked")
	private boolean findByEmail(String email) {
		List<Users> list = getSession()
				.createQuery("from Users where email = ?")
				.setParameter(0, email).list();
		return (list != null && list.size() == 0) ? false : true;
	}

	@SuppressWarnings("unchecked")
	public Users findByemail(String email) {
		List<Users> list = getSession()
				.createQuery("from Users where email = ?")
				.setParameter(0, email).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	public Users getUserForEdit(Long id) {
		List<Users> list = getSession().createQuery("from Users where id = ?")
				.setParameter(0, id).list();
		return list == null ? null : list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Users findByUsername(String username) {
		List<Users> list = getSession()
				.createQuery("from Users where username = ?")
				.setParameter(0, username).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Users findById(Long joinedId) {
		List<Users> list = getSession().createQuery("from Users where id = ?")
				.setParameter(0, joinedId).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Users> findByJoinedid(Long joinedId) {
		return getSession().createQuery("from Users where joinedId = ?")
				.setParameter(0, joinedId).list();		
	}

}
