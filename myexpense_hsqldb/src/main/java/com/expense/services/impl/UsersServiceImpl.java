/**
 * 
 */
package com.expense.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.UsersDAO;
import com.expense.hibernate.domains.Users;
import com.expense.services.UsersService;

/**
 * @author j.saini
 *
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDAO usersDao;
	
	@Override
	public String save(Users users) {
		// TODO Auto-generated method stub
		return usersDao.save(users);
	}
	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return usersDao.findByUsername(username);
	}
	@Override
	public Users findByemail(String username) {
		// TODO Auto-generated method stub
		return usersDao.findByemail(username);
	}
	@Override
	public Users findById(Long joinedId) {
		return usersDao.findById(joinedId);
	}
	@Override
	public List<Users> findByJoinedid(Long joinedId) {
		return usersDao.findByJoinedid(joinedId);
	}

}
