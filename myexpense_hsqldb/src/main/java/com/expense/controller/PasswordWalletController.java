package com.expense.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expense.hibernate.domains.PasswordWallet;
import com.expense.models.PasswordWalletModel;
import com.expense.models.SecurityQAModal;
import com.expense.services.CategoryService;
import com.expense.services.PasswordWalletService;
import com.expense.util.AppConstants;

/**
 * @author jitender.saini
 * 
 */
@Controller
@RequestMapping("/wallet")
public class PasswordWalletController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PasswordWalletService passwordWalletService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/action")
	public String loadForm(Model model) {		
		return AppConstants.PASSWORD_WALLET_LIST;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "search" })
	public String loadTable(Model model, @RequestParam Long userid) {		
		List<PasswordWallet> list = passwordWalletService.getAllEnteries(userid);
		model.addAttribute("list", list);
		return AppConstants.PASSWORD_WALLET_DATA_TABLE;
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
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "create" })
	public String createCategory(Model model,HttpServletRequest request) {
		model.addAttribute(
				"map",
				categoryService.fetchCategories4Wallet(request.getSession()
						.getAttribute("userid").toString()));
		
		model.addAttribute("wallet", new PasswordWalletModel());		
		return AppConstants.PASSWORD_WALLET_CREATE;
	}
	
	/**
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "qa" })
	public String createQA(Model model,HttpServletRequest request, PasswordWallet passwordWallet,String entryType) {
		//System.out.println("entryType: "+entryType);
		model.addAttribute("passwordWalletID", passwordWallet.getId());
		model.addAttribute("wallet", new SecurityQAModal());
		model.addAttribute("entryType", entryType);
		
		return AppConstants.PASSWORD_WALLET_CREATE_QA;
	}

	/**
	 * @param wallet
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "savemultiple" })
	public String saveMutipleCategories(PasswordWalletModel wallet,
			HttpServletRequest request) {		
		passwordWalletService.saveMultiple(
				wallet,
				Long.valueOf(request.getSession().getAttribute("login_id")
						.toString()));
		return AppConstants.PASSWORD_WALLET_DATA_TABLE;
	}
	
	/**
	 * @param qaModal
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "savemultipleQA" })
	public String saveQuestAns(SecurityQAModal qaModal,
			HttpServletRequest request) {
		passwordWalletService.saveQuestAns(
				qaModal,
				Long.valueOf(request.getSession().getAttribute("login_id")
						.toString()));
		return AppConstants.PASSWORD_WALLET_DATA_TABLE;
	}
	
	
	@RequestMapping(value = "/action", params = { "retrieve" })
	public @ResponseBody boolean retrievePassword(Long id, HttpServletRequest request) {		
		return passwordWalletService.retrievePassword(id,request.getSession().getAttribute("email").toString());
	}
	
	
	/**
	 * @param model
	 * @param category
	 * @return
	 */
	/*@RequestMapping(value = "/action", params = { "save" })
	public String saveCategory(Category category) {
		categoryService.save(category);
		return AppConstants.CATEGORY_DATA_TABLE;
	}*/

	/**
	 * @param model
	 * @param category
	 * @return
	 */
	/*@RequestMapping(value = "/action", params = { "remove" })
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
	}*/

	/**
	 * @param model
	 * @param category
	 * @return
	 */
	/*@RequestMapping(value = "/action", params = { "edit" })
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
	}*/
}
