/**
 * 
 */
package com.expense.dao;

import java.util.List;
import java.util.Set;

import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Notification;
import com.expense.hibernate.domains.Users;

/**
 * @author j.saini
 * 
 */
public interface NotificationDAO {

	List<Notification> fetchNotifications4DashBoard(String userid);

	List<Category> fetchCategoriesNotification(String userid);

	void save(Notification notification);

	void remove(String ids);

	List<Notification> getAllNotification(String userid);

	void deactivate(String ids);

	void saveMultiple(List<Notification> mainList);

	List<Notification> fetchEligibleNotifications();

	List<Users> fetchAllUsersFromMap(Set<Long> keySet);

}
