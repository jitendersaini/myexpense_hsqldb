package com.expense.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expense.hibernate.domains.Notification;
import com.expense.hibernate.domains.Users;
import com.expense.services.MailService;
import com.expense.util.AppUtils;
import com.google.common.collect.Multimap;

@Service
@Transactional
public class MailServiceImpl implements MailService {
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendMail(String from, String to, String subject, String body) {
		final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		MimeMessageHelper message;
		try {
			message = new MimeMessageHelper(mimeMessage,
					false /* multipart */, "UTF-8");
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		// mailSender.send(message);
		this.mailSender.send(mimeMessage);
	}

	@Override
	public void sendNotificationMail(List<Users> listUsers,
			Multimap<Long, Notification> map) {

		final MimeMessage[] mimeMessage = new MimeMessage[listUsers.size()];

		List<MimeMessageHelper> msgList = new ArrayList<MimeMessageHelper>();
		MimeMessageHelper message;
		try {
			int i = 0;
			for (Users user : listUsers) {
				mimeMessage[i] = this.mailSender.createMimeMessage();
				Collection<Notification> listNot = map.get(user.getId());
				StringBuilder body = new StringBuilder();
				int j = 1;

				body.append("Notification Title \t\t Notification Expired On \t\t Category \n\n");
				for (Notification notification : listNot) {
					body.append(j + ")  " + notification.getNotificationTitle());
					body.append("\t \t"
							+ AppUtils.getFormatedDate(
									notification.getNotificationEndDate(),
									"dd/MMM/yyyy"));
					body.append("\t \t"
							+ notification.getCategory().getCategoryName());
					body.append("\n");
					j++;
				}

				message = new MimeMessageHelper(mimeMessage[i],
						false /* multipart */, "UTF-8");
				message.setFrom("libms.system@gmail.com");
				message.setTo(user.getEmail());
				message.setSubject("Gentle reminder From Mybudget System");
				message.setText(body.toString());
				msgList.add(message);
				i++;
			}

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		// mailSender.send(message);
		this.mailSender.send(mimeMessage);
	}
}
