/**
 * 
 */
package com.expense.services.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.DataDAO;
import com.expense.hibernate.domains.Budget;
import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Expense;
import com.expense.hibernate.domains.Notification;
import com.expense.hibernate.domains.PaymentMode;
import com.expense.hibernate.domains.Users;
import com.expense.services.DataService;

/**
 * @author j.saini
 * 
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	DataDAO dataDAO;

	@Override
	public Boolean writeSql(String fileName) {
		// TODO Auto-generated method stub

		BufferedWriter writer = null;
		try {

			File logFile = new File(fileName);

			// This will output the full path where the file will be written
			// to...
			System.out.println(logFile.getCanonicalPath());

			writer = new BufferedWriter(new FileWriter(logFile));

			List<Users> listUsers = dataDAO.findAllUsers();
			List<Budget> listBudget = dataDAO.findAllBudget();
			List<Category> listCategries = dataDAO.findAllCategories();
			List<Expense> listExpense = dataDAO.findAllExpense();
			List<Notification> listNotification = dataDAO.findAllNotification();
			List<PaymentMode> listPaymentMode = dataDAO.findAllPaymentMode();
			
			writer.write("-------------BEGIN USERS TABLE--------------\n");
			for (Users users : listUsers) {
				writer.write("INSERT INTO users(access,color_theme,created_by,currency,deleted,email,enabled,joined_id,modified_by,name,password,username) VALUES ("
						+ users.getAccess()
						+ ",'"
						+ users.getColorTheme()
						+ "','"
						+ users.getCreatedDate()
						+ "','"
						+ users.getCurrency()
						+ "',"
						+ users.getDeleted()
						+ ",'"
						+ users.getEmail()
						+ "',"
						+ users.getEnabled()
						+ ","
						+ users.getJoinedId()
						+ ",'"
						+ users.getModifiedDate()
						+ "','"
						+ users.getName()
						+ "','"
						+ users.getPassword()
						+ "','"
						+ users.getUsername() + "')\n");
			}
			writer.write("-------------END USERS TABLE--------------\n\n");
			writer.write("-------------BEGIN CATEGORY TABLE--------------\n");
			for (Category category : listCategries) {
				writer.write("INSERT INTO category (category_name,category_type,created_date,modified_date,created_by,modified_by) VALUES('"
						+ category.getCategoryName()
						+ "',"
						+ category.getCategoryType()
						+ ",'"
						+ category.getCreatedDate()
						+ "','"
						+ category.getModifiedDate()
						+ "','"
						+ category.getUsersByCreatedBy().getId()
						+ "','"
						+ category.getUsersByModifiedBy().getId() + "')\n");
			}
			writer.write("-------------END CATEGORY TABLE--------------\n\n");
			writer.write("-------------BEGIN BUDGET TABLE--------------\n");
			for (Budget budget : listBudget) {
				String str = "INSERT INTO budget(month,value,year,created_by,modified_by) VALUES ("
						+ budget.getMonth()
						+ ","
						+ budget.getValue()
						+ ","
						+ budget.getYear()
						+ ","
						+ budget.getUsersByCreatedBy().getId()
						+ ","
						+ budget.getUsersByModifiedBy().getId() + ")\n";
				writer.write(str);
			}
			writer.write("-------------END BUDGET TABLE--------------\n\n");
			writer.write("-------------BEGIN PAYMENT MODE TABLE--------------\n");
			for (PaymentMode paymentMode : listPaymentMode) {
				writer.write("INSERT INTO payment_mode(created_date,modified_date,payment_mode,payment_mode_type,created_by,modified_by)VALUES('"
						+ paymentMode.getCreatedDate()
						+ "','"
						+ paymentMode.getModifiedDate()
						+ "','"
						+ paymentMode.getPaymentMode()
						+ "',"
						+ paymentMode.getPaymentModeType()
						+ ","
						+ paymentMode.getUsersByCreatedBy().getId()
						+ ","
						+ paymentMode.getUsersByModifiedBy().getId() + ")\n");
			}
			writer.write("-------------END PAYMENT MODE TABLE--------------\n\n");
			writer.write("-------------BEGIN EXPENSE TABLE--------------\n");
			for (Expense expense : listExpense) {
				writer.write("INSERT INTO expense(created_date,expense_date,expense_title,expense_value,modified_date,category_id,paid_via_id,created_by,modified_by)VALUES('"
						+ expense.getCreatedDate()
						+ "','"
						+ expense.getExpenseDate()
						+ "','"
						+ expense.getExpenseTitle()
						+ "',"
						+ expense.getExpenseValue()
						+ ",'"
						+ expense.getModifiedDate()
						+ "',"
						+ expense.getCategory().getId()
						+ ","
						+ expense.getPaymentMode().getId()
						+ ","
						+ expense.getUsersByCreatedBy().getId()
						+ ","
						+ expense.getUsersByModifiedBy().getId() + ")\n");
			}
			writer.write("-------------END EXPENSE TABLE--------------\n\n");
			writer.write("-------------BEGIN NOTIFICATION TABLE--------------\n");
			for (Notification notification : listNotification) {
				writer.write("INSERT INTO notification(created_date,modified_date,notification_due_date,notification_end_date,notification_start_date,notification_title,notify_days,notify_via,status,category_id,created_by,modified_by)VALUES('"
						+ notification.getCreatedDate()
						+ "','"
						+ notification.getModifiedDate()
						+ "','"
						+ notification.getNotificationDueDate()
						+ "','"
						+ notification.getNotificationEndDate()
						+ "','"
						+ notification.getNotificationStartDate()
						+ "','"
						+ notification.getNotificationTitle()
						+ "',"
						+ notification.getNotifyDays()
						+ ","
						+ notification.getNotifyVia()
						+ ","
						+ notification.getStatus()
						+ ","
						+ notification.getCategory().getId()
						+ ","
						+ notification.getUsersByCreatedBy().getId()
						+ ","
						+ notification.getUsersByModifiedBy().getId() + ")\n");
			}
			
			writer.write("-------------END NOTIFICATION TABLE--------------\n\n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} catch (Exception e) {
			}
		}
		return null;
	}

}
