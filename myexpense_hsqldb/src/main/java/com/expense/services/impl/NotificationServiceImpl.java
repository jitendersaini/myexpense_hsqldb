/**
 * 
 */
package com.expense.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.NotificationDAO;
import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Notification;
import com.expense.hibernate.domains.Users;
import com.expense.models.NotificationModal;
import com.expense.services.MailService;
import com.expense.services.NotificationService;
import com.expense.util.AppUtils;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author j.saini
 * 
 */
@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationDAO notificationDao;
	
	@Autowired
	MailService mailService;

	@Override
	public List<Notification> fetchNotifications4DashBoard(String userid) {
		return notificationDao.fetchNotifications4DashBoard(userid);
	}

	@Override
	public List<Category> fetchCategoriesNotification(String userid) {
		return notificationDao.fetchCategoriesNotification(userid);
	}

	@Override
	public void save(Notification notification) {
		if (notification.getId() == null) {
			notification.setStatus((int) 1);
			notification.setCreatedDate(new Date());
		}
		notification.setModifiedDate(new Date());
		notificationDao.save(notification);
	}

	@Override
	public void saveMultiple(NotificationModal notificationList, String userid) {
		List<Notification> mainList = new ArrayList<Notification>();
		Notification notification;
		int i = 0;
		Users users = new Users();
		users.setId(Long.valueOf(userid));
		for (String notTitle : notificationList.getNotifyTitle()) {
			notification = new Notification();
			notification.setCategory(new Category(Long.valueOf(notificationList.getCategoryid().get(i))));
			notification.setCreatedDate(new Date());
			notification.setId(null);
			notification.setModifiedDate(new Date());
			notification.setNotifyDays(notificationList.getNotifyDays().get(i));
			notification.setNotificationDueDate(AppUtils
					.getReducedDaysFromGivenDate(notificationList
							.getNotifyEndDate().get(i), notificationList
							.getNotifyDays().get(i)));
			notification.setNotificationEndDate(notificationList
					.getNotifyEndDate().get(i));
			notification.setNotificationStartDate(notificationList
					.getNotifyStartDate().get(i));
			notification.setNotificationTitle(notTitle);
			notification.setNotifyVia(notificationList.getNotifyVia().get(i));
			notification.setStatus((int) 1);
			notification.setUsersByCreatedBy(users);
			notification.setUsersByModifiedBy(users);
			mainList.add(notification);
			i++;
		}
		notificationDao.saveMultiple(mainList);
		// notificationDao.saveMultiple(notification, userid);
	}

	@Override
	public List<Notification> getAllNotification(String userid) {
		return notificationDao.getAllNotification(userid);
	}

	@Override
	public void remove(String ids) {
		notificationDao.remove(ids);
	}

	@Override
	public void deactivate(String ids) {
		notificationDao.deactivate(ids);
	}

	@Override
	public List<Notification> fetchEligibleNotifications() {		
		return notificationDao.fetchEligibleNotifications();
	}

	@Override
	public void sendBulkNotification(
			List<Notification> list) {
		Multimap<Long, Notification> map = HashMultimap.create();
		for (Notification notification : list) {
			map.put(notification.getUsersByCreatedBy().getId(), notification);
		}
		
		List<Users> listUsers = notificationDao.fetchAllUsersFromMap(map.keySet());		
		
		mailService.sendNotificationMail(listUsers, map);
		
	}

}
