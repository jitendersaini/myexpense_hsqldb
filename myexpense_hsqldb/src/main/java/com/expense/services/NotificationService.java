/**
 * 
 */
package com.expense.services;

import java.util.List;

import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Notification;
import com.expense.models.NotificationModal;

/**
 * @author j.saini
 *
 */
public interface NotificationService {

	List<Notification> fetchNotifications4DashBoard(String string);

	List<Category> fetchCategoriesNotification(String userid);

	void save(Notification notification);

	void saveMultiple(NotificationModal notification, String userid);

	List<Notification> getAllNotification(String userid);

	void remove(String id);

	void deactivate(String id);

	List<Notification> fetchEligibleNotifications();

	void sendBulkNotification(List<Notification> fetchEligibleNotifications);

}
