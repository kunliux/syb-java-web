package com.shouyubang.web.controller.page;

import com.shouyubang.web.model.Manager;
import com.shouyubang.web.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by SYL on 2017/8/25.
 */
@Controller

public class ManagerController {
    @Autowired
    private ManagerService managerService;



    @RequestMapping(value="/managerlogin",method= RequestMethod.GET)
    public String managerLogin(@PathVariable String phone){
        System.out.println("manager try login in");
        managerService.findManagerByPhone(phone);
        return "success";
    }
    @RequestMapping(value = { "/managernew" }, method = RequestMethod.GET)
    public String newManager(ModelMap model) {
        Manager manager = new Manager();
        model.addAttribute("manager", manager);
        model.addAttribute("edit", false);
        return "addManager";
    }
    /*
     * This method will be called on form submission, handling POST request for
     * saving staff in database. It also validates the user input
     */
    @RequestMapping(value = { "/managernew" }, method = RequestMethod.POST)
    public String saveManager(@Valid Manager manager, BindingResult result,
                              ModelMap model) {

        if (result.hasErrors()) {
            return "addManager";
        }

		/*
		 * Preferred way to achieve uniqueness of field [idnumber] should be implementing custom @Unique annotation
		 * and applying it on field [idnumber] of Model class [Manager].
		 *
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 *
		 */
	/*	if(!managerService.isManagerPhoneUnique(manager.getId(), manager.getPhone())){
			FieldError phoneError =new FieldError("manager","phone",messageSource.getMessage("non.unique.phone", new String[]{manager.getPhone()}, Locale.getDefault()));
			result.addError(phoneError);
			return "registration";
		} */

        managerService.saveManager(manager);

        model.addAttribute("success", "Manager " + manager.getUsername() + " registered successfully");
        return "home";
    }



}
