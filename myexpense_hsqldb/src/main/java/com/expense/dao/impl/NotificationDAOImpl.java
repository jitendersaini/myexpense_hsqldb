/**
 * 
 */
package com.expense.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.NotificationDAO;
import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Notification;
import com.expense.hibernate.domains.Users;
import com.expense.util.AppUtils;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class NotificationDAOImpl extends MyExpenseHibernateSessionFactory
		implements NotificationDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> fetchNotifications4DashBoard(String userid) {
		return getSession()
				.createQuery(
						"from Notification where usersByCreatedBy.id  in (:userids) and status = 1 order by notificationEndDate asc")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> fetchCategoriesNotification(String userid) {
		return getSession()
				.createQuery(
						"from Category where usersByCreatedBy.id  in (:userids) and categoryType = 2 order by categoryName asc")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).list();

	}

	@Override
	public void save(Notification notification) {
		getSession().saveOrUpdate(notification);
	}

	@Override
	public void saveMultiple(List<Notification> mainList) {
		Session session = getSession();
		for (Notification notification : mainList) {
			session.save(notification);
		}

	}

	@Override
	public void remove(String ids) {
		getSession()
				.createQuery("delete from Notification where id in (:ids)")
				.setParameterList("ids",
						AppUtils.convertToLongArray(ids.split(",")))
				.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> getAllNotification(String userid) {

		return getSession()
				.createQuery(
						"from Notification where usersByCreatedBy.id  in (:userids)")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void deactivate(String ids) {

		List<Notification> list = getSession()
				.createQuery("from Notification where id in (:userids)")
				.setParameterList("userids",
						AppUtils.convertToLongArray(ids.toString().split(",")))
				.list();

		for (Notification notification : list) {
			notification.setStatus((int) 2);
			notification.setModifiedDate(new Date());
			getSession().save(notification);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> fetchEligibleNotifications() {		
		return getSession()
				.createQuery(
						"from Notification where status =1 and notificationDueDate <= :dueDate and notificationEndDate >= :endDate order by notificationEndDate asc")
				.setParameter("dueDate", new Date())
				.setParameter("endDate", new Date()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> fetchAllUsersFromMap(Set<Long> keySet) {
		List<Users> list = getSession()
				.createQuery(
						"from Users where id in (:userids) order by username asc")
				.setParameterList("userids", keySet).list();
		System.out.println("List Size: "+list.size());
		return list;
	}
}
