package com.shouyubang.web.dao;

import com.shouyubang.web.model.Account;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl extends AbstractDao<Integer, Account> implements AccountDao {
	@Override
	public Account getAccount(int id) {
		return getByKey(id);
	}
	@Override
	public void saveAccount(Account account) {
		persist(account);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Account> listAllAccounts() {
		Criteria criteria = createEntityCriteria();
		return (List<Account>) criteria.list();
	}
	@Override
	public void updateAccount(Account account) {
	    update(account);
    }
	@Override
	public Account getAccountByPhone(String phone) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("phone", phone));
		return (Account) criteria.uniqueResult();
	}
	@Override
	public int countMatchAccount(String userName, String password) {
		return 0;
	}
	@Override
	public void deleteAccountByPhone(String phone) {
		Query query = getSession().createSQLQuery("delete from ACCOUNT where phone = :phone");
		query.setString("phone", phone);
		query.executeUpdate();
	}

}
