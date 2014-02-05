/**
 * 
 */
package com.expense.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.CategoryDAO;
import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Users;
import com.expense.models.CategoryModal;
import com.expense.services.CategoryService;

/**
 * @author j.saini
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getAllCategories(Long userid, Integer categoryType) {
		// TODO Auto-generated method stub
		return categoryDAO.getAllCategories(userid,categoryType);
	}

	@Override
	public void saveMultiple(CategoryModal categoryList, Long loginId) {
		// TODO Auto-generated method stub
		List<Category> mainList = new ArrayList<Category>();
		Category category;
		int i=0;
		Users users = new Users();
		users.setId(loginId);
		for (String name : categoryList.getCategoryName()) {
			category = new Category();
			category.setCategoryName(name);
			category.setCategoryType((int)categoryList.getCategoryType().get(i));
			category.setCreatedDate(new Date());
			category.setId(null);
			category.setModifiedDate(new Date());
			category.setUsersByCreatedBy(users);
			category.setUsersByModifiedBy(users);
			mainList.add(category);
			i++;
		}
		// category.setUsers(usersService.findById());
		categoryDAO.saveMultiple(mainList);
	}

	@Override
	public void save(Category category) {
		if (category.getId() ==null) {
			category.setCreatedDate(new Date());
		}
		category.setModifiedDate(new Date());
		categoryDAO.save(category);
	}

	@Override
	public void remove(String ids) {
		categoryDAO.remove(ids);
	}

	@Override
	public List<Category> fetchCategories(String userid) {
		return categoryDAO.fetchCategories(userid);
	}

	@Override
	public List<Category> fetchCategories4Wallet(String userid) {
		return categoryDAO.fetchCategories4Wallet(userid);
	}

	
}
