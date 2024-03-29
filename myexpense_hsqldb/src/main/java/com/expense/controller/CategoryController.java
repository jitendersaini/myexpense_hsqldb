package com.expense.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.Expense;
import com.expense.models.CategoryModal;
import com.expense.services.CategoryService;
import com.expense.services.ExpenseService;
import com.expense.util.AppConstants;

/**
 * @author jitender
 * 
 */
/**
 * @author jitender.saini
 * 
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ExpenseService expenseService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/action")
	public String loadForm(Model model) {
		Map<Short, String> map = new HashMap<Short, String>();
		map.put((short) 1, "Expense");
		map.put((short) 2, "Notification");
		map.put((short) 3, "Password Wallet");
		model.addAttribute("map", map);
		return AppConstants.CATEGORY_LIST;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "search" })
	public String loadTable(Model model, @RequestParam Long userid,
			@RequestParam Integer categoryType) {
		List<Category> list = categoryService.getAllCategories(userid,
				categoryType);
		model.addAttribute("list", list);
		return AppConstants.CATEGORY_DATA_TABLE;
	}

	/*
	 * @RequestMapping(value = "/action", params = { "searchcatall" }) public
	 * String loadCat(Model model, HttpServletRequest request) { List<Category>
	 * list = categoryService.getAllCategoriesByUserName(request
	 * .getSession().getAttribute("userid").toString());
	 * model.addAttribute("list", list); return "employee_views"; }
	 */

	/**
	 * @param model
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "create" })
	public String createCategory(Model model) {
		model.addAttribute("category", new CategoryModal());
		Map<Short, String> map = new HashMap<Short, String>();
		map.put((short) 1, "Expense");
		map.put((short) 2, "Notification");
		map.put((short) 3, "Password Wallet");
		model.addAttribute("map", map);
		return AppConstants.CATEGORY_CREATE;
	}

	@RequestMapping(value = "/action", params = { "savemultiple" })
	public String saveMutipleCategories(CategoryModal category, HttpServletRequest request) {
		categoryService.saveMultiple(category,Long.valueOf(request.getSession().getAttribute("login_id").toString()));
		return AppConstants.CATEGORY_DATA_TABLE;
	}
	
	/**
	 * @param model
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "save" })
	public String saveCategory(Category category) {
		categoryService.save(category);
		return AppConstants.CATEGORY_DATA_TABLE;
	}

	/**
	 * @param model
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "remove" })
	public @ResponseBody
	String removeCategory(Model model, String id) {		
		List<Expense> list = expenseService.isCategoryMapped(id);
		if (list == null || list.isEmpty()) {
			categoryService.remove(id);
			return "";
		} else {
			StringBuilder stb = new StringBuilder();
			for (Expense expense : list) {
				stb.append(expense.getCategory().getCategoryName());
				stb.append(" | ");
			}
			String str = stb.toString();
			return (str.substring(0, str.lastIndexOf(" | ")));
		}
	}

	/**
	 * @param model
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "edit" })
	public String editCategory(Model model, Category category) {		
		if (expenseService.isCategoryIdMapped(category.getId()) == null) {
			model.addAttribute("isCategoryMapped", false);
		} else {
			model.addAttribute("isCategoryMapped", true);
		}
		Map<Short, String> map = new HashMap<Short, String>();
		map.put((short) 1, "Expense");
		map.put((short) 2, "Notification");
		map.put((short) 3, "Password Wallet");
		model.addAttribute("map", map);
		model.addAttribute("category", category);
		return AppConstants.CATEGORY_MODIFY;
	}
}
