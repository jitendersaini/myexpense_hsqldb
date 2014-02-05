/**
 * 
 */
package com.expense.services;

import java.util.List;

import com.expense.hibernate.domains.PasswordWallet;
import com.expense.models.PasswordWalletModel;
import com.expense.models.SecurityQAModal;


/**
 * @author j.saini
 * 
 */
public interface PasswordWalletService {

	List<PasswordWallet> getAllEnteries(Long userid);

	void saveMultiple(PasswordWalletModel wallet, Long userid);

	void saveQuestAns(SecurityQAModal qaModal, Long userid);
	
	boolean retrievePassword(Long id, String email);

}
