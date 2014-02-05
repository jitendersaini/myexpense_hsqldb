package com.expense.models;

import java.util.ArrayList;
import java.util.Date;

import com.expense.hibernate.domains.Users;

/**
 * @author Jitender
 * 
 */
public class SecurityQAModal {

	private ArrayList<Long> id;
	private ArrayList<Users> usersByCreatedBy;
	private ArrayList<String> securityQuestion;
	private ArrayList<String> securityAnswer;
	private ArrayList<String> passwordWalletId;
	private ArrayList<Date> createdDate;
	private ArrayList<Date> modifiedDate;

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
	 * @return the passwordWalletId
	 */
	public ArrayList<String> getPasswordWalletId() {
		return passwordWalletId;
	}

	/**
	 * @param passwordWalletId
	 *            the passwordWalletId to set
	 */
	public void setPasswordWalletId(ArrayList<String> passwordWalletId) {
		this.passwordWalletId = passwordWalletId;
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
