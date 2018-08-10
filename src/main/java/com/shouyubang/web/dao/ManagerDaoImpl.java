package com.shouyubang.web.dao;

import com.shouyubang.web.model.Manager;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("managerDao")
public class ManagerDaoImpl extends AbstractDao<Integer, Manager> implements ManagerDao {

	public Manager findById(int id) {
		return getByKey(id);
	}

	public void saveManager(Manager manager) {
		persist(manager);
	}

//	public Manager findManagerByPhone(String phone) {
	//	Query query = getSession().createSQLQuery("SELECT password from MANAGER where phone = :phone");
	//	query.setString("phone", phone);
	//	query.executeUpdate();
	//	return success;
//	}


	//public List<Manager> findAllManagers() {
	//	Criteria criteria = createEntityCriteria();
//	return (List<Manager>) criteria.list();
	//}

	public Manager findManagerByPhone(String phone) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("phone", phone));
	return (Manager) criteria.uniqueResult();
//	}
	}
}