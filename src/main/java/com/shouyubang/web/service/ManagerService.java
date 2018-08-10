package com.shouyubang.web.service;

import com.shouyubang.web.dao.ManagerDao;
import com.shouyubang.web.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SYL on 2017/9/13.
 */
@Service("managerService")
@Transactional
@ComponentScan("com.shouyubang.web.dao")
public class ManagerService {

    @Autowired
    private ManagerDao managerdao;

    public Manager findById(int id) {
        return managerdao.findById(id);
    }

    public void saveManager(Manager manager) {
        managerdao.saveManager(manager);
    }

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends.
	 */
/*	public void updateManager(Manager staff) {
		Manager entity = dao.findById(staff.getId());
		if(entity!=null){
            entity.setIdnumber(staff.getIdnumber());
			entity.setName(staff.getName());
            entity.setPhone(staff.getPhone());
			entity.setPassword(staff.getPassword());


		}
	}

	public void deleteManagerByIdnumber(String idnumber) {
		dao.deleteManagerByIdnumber(idnumber);
	}

	public List<Manager> findAllManagers() {
		return dao.findAllManagers();
	}*/

    public Manager findManagerByPhone(String phone) {
        return managerdao.findManagerByPhone(phone);
    }

    public boolean isManagerPhoneUnique(Integer id, String phone) {
        Manager manager = findManagerByPhone(phone);
        return ( manager == null || ((id != null) && (manager.getId() == id)));
    }

}
