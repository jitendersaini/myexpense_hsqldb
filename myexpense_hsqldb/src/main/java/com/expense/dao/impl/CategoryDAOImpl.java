/**
 * 
 */
package com.expense.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.expense.dao.CategoryDAO;
import com.expense.hibernate.domains.Category;
import com.expense.util.AppUtils;
import com.expense.util.MyExpenseHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class CategoryDAOImpl extends MyExpenseHibernateSessionFactory implements
		CategoryDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories(Long userid, Integer categoryType) {

		List<Category> list = getSession()
				.createQuery(
						"from Category cat where cat.usersByCreatedBy.id  in (:userids) and categoryType = :categoryType")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(",")))
				.setParameter("categoryType", categoryType).list();

		return list;
	}

	@Override
	public void saveMultiple(List<Category> mainList) {
		// TODO Auto-generated method stub
		Session session = getSession();
		for (Category category : mainList) {
			session.save(category);
		}
	}

	@Override
	public void save(Category category) {
		getSession().saveOrUpdate(category);
	}

	@Override
	public void remove(String ids) {
		getSession()
				.createQuery("delete from Category where id in (:ids)")
				.setParameterList("ids",
						AppUtils.convertToLongArray(ids.split(",")))
				.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> fetchCategories(String userid) {
		List<Category> list = getSession()
				.createQuery(
						"from Category cat where cat.usersByCreatedBy.id  in (:userids) and cat.categoryType = :catType")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).setParameter("catType", 1).list();

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> fetchCategories4Wallet(String userid) {
		List<Category> list = getSession()
				.createQuery(
						"from Category cat where cat.usersByCreatedBy.id  in (:userids) and cat.categoryType = :catType")
				.setParameterList(
						"userids",
						AppUtils.convertToLongArray(userid.toString()
								.split(","))).setParameter("catType", 3).list();

		return list;
	}
}
