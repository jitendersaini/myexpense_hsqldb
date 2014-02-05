/**
 * 
 */
package com.expense.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.PasswordWalletDAO;
import com.expense.hibernate.domains.Category;
import com.expense.hibernate.domains.PasswordWallet;
import com.expense.hibernate.domains.SecurityQA;
import com.expense.hibernate.domains.Users;
import com.expense.models.PasswordWalletModel;
import com.expense.models.SecurityQAModal;
import com.expense.security.wallet.EncDec;
import com.expense.services.MailService;
import com.expense.services.PasswordWalletService;

/**
 * @author j.saini
 * 
 */
@Service
public class PasswordWalletServiceImpl implements PasswordWalletService {

	@Autowired
	PasswordWalletDAO PasswordWalletDAO;
	
	@Autowired
	MailService mailService;

	@Override
	public List<PasswordWallet> getAllEnteries(Long userid) {
		return PasswordWalletDAO.getAllEnteries(userid);
	}

	@Override
	public void saveMultiple(PasswordWalletModel walletList, Long userid) {
		List<PasswordWallet> mainList = new ArrayList<PasswordWallet>();
		PasswordWallet passwordWallet;
		int i=0;
		Users users = new Users();
		users.setId(userid);
		for (String categoryid : walletList.getCategoryid()) {
			passwordWallet = new PasswordWallet();			
			passwordWallet.setCategory(new Category(Long.valueOf(categoryid)));
			passwordWallet.setCreatedDate(new Date());
			passwordWallet.setModifiedDate(new Date());
			passwordWallet.setExpiryDays(walletList.getExpiryDays().get(i));			
			passwordWallet.setPassword(EncDec.encrypt(walletList.getPassword().get(i)));
			if(StringUtils.isNotEmpty(walletList.getUserid().get(i))) {
				passwordWallet.setUserid(walletList.getUserid().get(i));
			}
			passwordWallet.setUsersByCreatedBy(users);
			passwordWallet.setUsersByModifiedBy(users);
			
			mainList.add(passwordWallet);
			i++;
		}
		// category.setUsers(usersService.findById());
		PasswordWalletDAO.saveMultiple(mainList);
	}

	@Override
	public void saveQuestAns(SecurityQAModal qaModal, Long userid) {
		List<SecurityQA> mainList = new ArrayList<SecurityQA>();
		SecurityQA securityQA;
		int i=0;
		Users users = new Users();
		users.setId(userid);
		for (String question : qaModal.getSecurityQuestion()) {
			securityQA = new SecurityQA();	
			securityQA.setCreatedDate(new Date());
			securityQA.setModifiedDate(new Date());
			securityQA.setPasswordWallet(new PasswordWallet(Long.valueOf(qaModal.getPasswordWalletId().get(i))));
			securityQA.setSecurityQuestion(question);
			securityQA.setSecurityAnswer(qaModal.getSecurityAnswer().get(i));
			securityQA.setUsersByCreatedBy(users);
			securityQA.setUsersByModifiedBy(users);			
			
			mainList.add(securityQA);
			i++;
		}
		// category.setUsers(usersService.findById());
		PasswordWalletDAO.saveQuestAns(mainList);
	}

	@Override
	public boolean retrievePassword(Long id,String email) {
		boolean flag = false;
		List<PasswordWallet> list= PasswordWalletDAO.retrievePassword(id);
		String password = null;
		String userid = null;
		String type = null;
		for (PasswordWallet passwordWallet : list) {
			type = passwordWallet.getCategory().getCategoryName();
			userid = passwordWallet.getUserid();
			password = EncDec.decrypt(passwordWallet.getPassword());
		}
		mailService.sendMail("libms.system@gmail.com", email, "Thre Retrieved Password ...", "The userid for: "+type+" is: "+userid+" and password is: "+password);
		//System.out.println("list-----------> "+list.size());
		flag = true;
		return flag;
	}

}
