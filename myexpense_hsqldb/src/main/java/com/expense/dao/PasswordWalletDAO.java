/**
 * 
 */
package com.expense.dao;

import java.util.List;

import com.expense.hibernate.domains.PasswordWallet;
import com.expense.hibernate.domains.SecurityQA;



/**
 * @author j.saini
 *
 */
public interface PasswordWalletDAO {

	List<PasswordWallet> getAllEnteries(Long userid);

	void saveMultiple(List<PasswordWallet> mainList);

	void saveQuestAns(List<SecurityQA> mainList);
	
	List<PasswordWallet> retrievePassword(Long id);
}
