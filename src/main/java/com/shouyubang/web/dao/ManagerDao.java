package com.shouyubang.web.dao;

import com.shouyubang.web.model.Manager;

public interface ManagerDao {

	Manager findById(int id);

	void saveManager(Manager manager);
	
	//void deleteManagerByIdnumber(String idnumber);
	
	//List<Manager> findAllManagers();

	Manager findManagerByPhone(String phone);

}
