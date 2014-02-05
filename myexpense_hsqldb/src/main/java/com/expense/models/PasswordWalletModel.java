package com.expense.models;

import java.util.ArrayList;
import java.util.Date;

import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Users;

public class PasswordWalletModel {

	private ArrayList<Long> id;
	private ArrayList<String> categoryid;
	private ArrayList<Users> usersByCreatedBy;
	private ArrayList<Category> category;
	private ArrayList<String> userid;
	private ArrayList<String> password;
	private ArrayList<String> securityQuestion;
	private ArrayList<String> securityAnswer;
	private ArrayList<Integer> expiryDays;
	private ArrayList<Date> createdDate;
	private ArrayList<Date> modifiedDate;

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

	/**
	 * @return the id
	 */
	public ArrayList<Long> getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ArrayList<Long> id) {
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
	 * @return the userid
	 */
	public ArrayList<String> getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(ArrayList<String> userid) {
		this.userid = userid;
	}

	/**
	 * @return the password
	 */
	public ArrayList<String> getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(ArrayList<String> password) {
		this.password = password;
	}

	/**
	 * @return the securityQuestion
	 */
	public ArrayList<String> getSecurityQuestion() {
		return securityQuestion;
	}

	/**
	 * @param securityQuestion
	 *            the securityQuestion to set
	 */
	public void setSecurityQuestion(ArrayList<String> securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	/**
	 * @return the securityAnswer
	 */
	public ArrayList<String> getSecurityAnswer() {
		return securityAnswer;
	}

	/**
	 * @param securityAnswer
	 *            the securityAnswer to set
	 */
	public void setSecurityAnswer(ArrayList<String> securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	/**
	 * @return the expiryDays
	 */
	public ArrayList<Integer> getExpiryDays() {
		return expiryDays;
	}

	/**
	 * @param expiryDays
	 *            the expiryDays to set
	 */
	public void setExpiryDays(ArrayList<Integer> expiryDays) {
		this.expiryDays = expiryDays;
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

}
