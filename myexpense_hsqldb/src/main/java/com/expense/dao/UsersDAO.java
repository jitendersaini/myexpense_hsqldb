/**
 * 
 */
package com.expense.dao;

import java.util.List;

import com.expense.hibernate.domains.Users;

/**
 * @author j.saini
 *
 */
public interface UsersDAO {

	String save(Users users);

	Users findByUsername(String username);

	Users findByemail(String username);

	Users findById(Long joinedId);

	List<Users> findByJoinedid(Long joinedId);

}
