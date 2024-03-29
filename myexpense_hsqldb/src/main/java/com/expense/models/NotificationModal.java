package com.expense.models;

import java.util.ArrayList;
import java.util.Date;

import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Users;

public class NotificationModal {

	private ArrayList<String> id;
	private ArrayList<String> categoryid;
	private ArrayList<Users> usersByCreatedBy;
	private ArrayList<Users> usersByModifiedBy;
	private ArrayList<String> notifyTitle;
	private ArrayList<Date> notifyStartDate;
	private ArrayList<Date> notifyEndDate;
	private ArrayList<Date> notifyDueDate;
	private ArrayList<Integer> notifyDays;
	private ArrayList<Integer> notifyVia;
	private ArrayList<Short> status; // 1-active, 0-inactive
	private ArrayList<Date> createdDate;
	private ArrayList<Date> modifiedDate;
	private ArrayList<Category> category;

	/**
	 * @return the id
	 */
	public ArrayList<String> getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ArrayList<String> id) {
		this.id = id;
	}

	/**
	 * @return the usersByCreatedBy
	 */
	public ArrayList<Users> getUsersByCreatedBy() {
		return usersByCreatedBy;
	}

	/**
	 * @param usersByCreatedBy
	 *            the usersByCreatedBy to set
	 */
	public void setUsersByCreatedBy(ArrayList<Users> usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	/**
	 * @return the usersByModifiedBy
	 */
	public ArrayList<Users> getUsersByModifiedBy() {
		return usersByModifiedBy;
	}

	/**
	 * @param usersByModifiedBy
	 *            the usersByModifiedBy to set
	 */
	public void setUsersByModifiedBy(ArrayList<Users> usersByModifiedBy) {
		this.usersByModifiedBy = usersByModifiedBy;
	}

	/**
	 * @return the notifyTitle
	 */
	public ArrayList<String> getNotifyTitle() {
		return notifyTitle;
	}

	/**
	 * @param notifyTitle
	 *            the notifyTitle to set
	 */
	public void setNotifyTitle(ArrayList<String> notifyTitle) {
		this.notifyTitle = notifyTitle;
	}

	/**
	 * @return the notifyStartDate
	 */
	public ArrayList<Date> getNotifyStartDate() {
		return notifyStartDate;
	}

	/**
	 * @param notifyStartDate
	 *            the notifyStartDate to set
	 */
	public void setNotifyStartDate(ArrayList<Date> notifyStartDate) {
		this.notifyStartDate = notifyStartDate;
	}

	/**
	 * @return the notifyEndDate
	 */
	public ArrayList<Date> getNotifyEndDate() {
		return notifyEndDate;
	}

	/**
	 * @param notifyEndDate
	 *            the notifyEndDate to set
	 */
	public void setNotifyEndDate(ArrayList<Date> notifyEndDate) {
		this.notifyEndDate = notifyEndDate;
	}

	/**
	 * @return the notifyDueDate
	 */
	public ArrayList<Date> getNotifyDueDate() {
		return notifyDueDate;
	}

	/**
	 * @param notifyDueDate
	 *            the notifyDueDate to set
	 */
	public void setNotifyDueDate(ArrayList<Date> notifyDueDate) {
		this.notifyDueDate = notifyDueDate;
	}

	/**
	 * @return the notifyDays
	 */
	public ArrayList<Integer> getNotifyDays() {
		return notifyDays;
	}

	/**
	 * @param notifyDays
	 *            the notifyDays to set
	 */
	public void setNotifyDays(ArrayList<Integer> notifyDays) {
		this.notifyDays = notifyDays;
	}

	/**
	 * @return the notifyVia
	 */
	public ArrayList<Integer> getNotifyVia() {
		return notifyVia;
	}

	/**
	 * @param notifyVia
	 *            the notifyVia to set
	 */
	public void setNotifyVia(ArrayList<Integer> notifyVia) {
		this.notifyVia = notifyVia;
	}

	/**
	 * @return the status
	 */
	public ArrayList<Short> getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(ArrayList<Short> status) {
		this.status = status;
	}

	/**
	 * @return the createdDate
	 */
	public ArrayList<Date> getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(ArrayList<Date> createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public ArrayList<Date> getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(ArrayList<Date> modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the category
	 */
	public ArrayList<Category> getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(ArrayList<Category> category) {
		this.category = category;
	}

	/**
	 * @return the categoryid
	 */
	public ArrayList<String> getCategoryid() {
		return categoryid;
	}

	/**
	 * @param categoryid
	 *            the categoryid to set
	 */
	public void setCategoryid(ArrayList<String> categoryid) {
		this.categoryid = categoryid;
	}

}
