package com.shouyubang.web.service;

import com.shouyubang.web.dao.AccountDao;
import com.shouyubang.web.dao.StaffInfoDao;
import com.shouyubang.web.dao.StaffInfoDaoImpl;
import com.shouyubang.web.model.Account;
import com.shouyubang.web.model.Response;
import com.shouyubang.web.utils.ApiConstants;
import com.shouyubang.web.utils.TlsSignatureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@ComponentScan("com.shouyubang.web.dao")
public class AccountService {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private StaffInfoDaoImpl staffInfoDao;

	@Transactional
	public void addAccount(Account account) {
		String username = 'm' + account.getPhone().substring(3); //普通用户username以m打头
		account.setUsername(username);
		accountDao.saveAccount(account);
	}

	@Transactional
	public void addStaffAccount(Account account) {

		String username = 's'+ account.getPhone().substring(3); //服务人员username以s打头
		account.setUsername(username);
		String phone = account.getPhone();
		account.setPhone(phone);
		account.setPassword("123456");
		accountDao.saveAccount(account);
	}

	@Transactional
	public Account findOne(Integer id) {
		Account u = accountDao.getAccount(id);
		System.out.print(u.toString());
		return u;
	}

	@Transactional
	public Response validateAccount(String identifier, String password) {
		Response response = new Response(-1, "FAIL");
		Account u = accountDao.getAccountByPhone(identifier);
		String userSig = "";
		if (null != u && u.getPassword().equals(password)) {
			userSig = TlsSignatureUtil.getUserSig(identifier);
		} else {
			response.setData("该账户不存在或者密码错误");
		}
		if (0 == userSig.length()) {
			response.setData("该账户秘钥生成失败");
		} else {
			response.setCode(2);
			response.setMessage("SUCCESS");
			response.setData(userSig);
		}
		return response;
	}

	public Response checkoutAccount(String identifier) {
		return new Response(3, "SUCCESS");
	}

	@Transactional
	public Account getAccountByPhone(String phone) {
		return accountDao.getAccountByPhone(phone);
	}

	@Transactional
	public Response updateStaffStatus(String staffId, Integer status) {
		Response response = new Response(25, "SUCCESS");
		staffInfoDao.updateStaffStatus(staffId, status);
		return response;
	}

	@Transactional
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

}