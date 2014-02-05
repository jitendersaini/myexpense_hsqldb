/**
 * 
 */
package com.expense.services;

import java.util.List;

import com.expense.hibernate.domains.Category;
import com.expense.models.CategoryModal;

/**
 * @author j.saini
 * 
 */
public interface CategoryService {

	List<Category> getAllCategories(Long userid, Integer categoryType);

	void saveMultiple(CategoryModal category, Long loginid);

	void save(Category category);

	void remove(String catids);

	List<Category> fetchCategories(String userid);

	List<Category> fetchCategories4Wallet(String string);

}
