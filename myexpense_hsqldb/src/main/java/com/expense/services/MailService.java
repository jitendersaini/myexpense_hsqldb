/**
 * 
 */
package com.expense.services;

import java.util.List;

import com.expense.hibernate.domains.Notification;
import com.expense.hibernate.domains.Users;
import com.google.common.collect.Multimap;

/**
 * @author j.saini
 * 
 */
public interface MailService {
	public void sendMail(String from, String to, String subject, String body);

	public void sendNotificationMail(List<Users> listUsers,
			Multimap<Long, Notification> map);

}
