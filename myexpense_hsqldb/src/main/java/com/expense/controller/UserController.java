package com.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.expense.hibernate.domains.Users;
import com.expense.services.UsersService;

/**
 * @author jitender
 * 
 */
@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UsersService usersService;

	/**
	 * @param model
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/action", params = { "save" })
	public @ResponseBody
	String saveUsers(Model model, Users users) {
		return usersService.save(users);
	}
}
