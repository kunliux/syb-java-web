package com.shouyubang.web.dao;

import com.shouyubang.web.model.Account;

import java.util.List;

public interface AccountDao {

	Account getAccount(int id);

	void saveAccount(Account account);

//	void savePageAccount(String username, String phone);

	List<Account> listAllAccounts();

	void updateAccount(Account account);

	Account getAccountByPhone(String phone);

	int countMatchAccount(String phone, String password);

	void deleteAccountByPhone(String phone);
}
