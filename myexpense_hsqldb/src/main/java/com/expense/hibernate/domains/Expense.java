package com.expense.hibernate.domains;

// Generated Jul 14, 2013 4:30:53 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Expense generated by hbm2java
 */
@Entity
@Table(name = "expense")
public class Expense implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5625896377335746089L;
	private Long id;
	private Users usersByCreatedBy;
	private PaymentMode paymentMode;
	private Users usersByModifiedBy;
	private Category category;
	private String expenseTitle;
	private Double expenseValue;
	private Date expenseDate;
	private Date createdDate;
	private Date modifiedDate;

	public Expense() {
	}

	public Expense(Users usersByCreatedBy, PaymentMode paymentMode,
			Users usersByModifiedBy, Category category, String expenseTitle,
			Double expenseValue, Date expenseDate, Date createdDate,
			Date modifiedDate) {
		this.usersByCreatedBy = usersByCreatedBy;
		this.paymentMode = paymentMode;
		this.usersByModifiedBy = usersByModifiedBy;
		this.category = category;
		this.expenseTitle = expenseTitle;
		this.expenseValue = expenseValue;
		this.expenseDate = expenseDate;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_by")
	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paid_via_id")
	public PaymentMode getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "modified_by")
	public Users getUsersByModifiedBy() {
		return this.usersByModifiedBy;
	}

	public void setUsersByModifiedBy(Users usersByModifiedBy) {
		this.usersByModifiedBy = usersByModifiedBy;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "expense_title", length = 145)
	public String getExpenseTitle() {
		return this.expenseTitle;
	}

	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}

	@Column(name = "expense_value", precision = 22, scale = 0)
	public Double getExpenseValue() {
		return this.expenseValue;
	}

	public void setExpenseValue(Double expenseValue) {
		this.expenseValue = expenseValue;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expense_date", length = 19)
	public Date getExpenseDate() {
		return this.expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", length = 19)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}