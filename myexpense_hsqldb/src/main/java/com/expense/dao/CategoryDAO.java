/**
 * 
 */
package com.expense.dao;

import java.util.List;

import com.expense.hibernate.domains.Category;


/**
 * @author j.saini
 *
 */
public interface CategoryDAO {

	List<Category> getAllCategories(Long userid, Integer categoryType);

	void saveMultiple(List<Category> mainList);

	void save(Category category);

	void remove(String ids);

	List<Category> fetchCategories(String userid);

	List<Category> fetchCategories4Wallet(String userid);

}
