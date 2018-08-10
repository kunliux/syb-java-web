package com.shouyubang.web.controller.page;

import com.shouyubang.web.model.UserProfile;
import com.shouyubang.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

import static org.bouncycastle.crypto.tls.ContentType.alert;

/**
 * Created by SYL on 2017/8/30.
 */
@Controller
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = {"/userlist"}, method = RequestMethod.GET)
    public String listJobs(ModelMap model) {

        List<UserProfile> users = userInfoService.findAllUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }


    @RequestMapping(value = {"/deleteuser/{id}"}, method = RequestMethod.GET)
    public String deleteUserById(@PathVariable int id) {
        userInfoService.deleteUserById(id);
        return "redirect:/userlist";
    }

    @RequestMapping(value = {"userDetail/{phone}"}, method = RequestMethod.GET)
    public String UserDetail(@PathVariable String phone, ModelMap model) {
        UserProfile user = userInfoService.findByPhone(phone);
        model.addAttribute("user", user);
           model.addAttribute("edit", true);
        return "userDetail";

    }
    @RequestMapping(value = { "userDetail/{phone}" }, method = RequestMethod.POST)
    public String UserDetail(@Valid UserProfile user,@PathVariable String phone,BindingResult result,
                             ModelMap model) {

        if (result.hasErrors()) {
            return "userDetail";
        }

        userInfoService.updateUser(user);

//        model.addAttribute("success", "用户资料更新成功");
        return "redirect:/userDetail/{phone}";
    }


    @RequestMapping(value = {"userInfo/{phone}"}, method = RequestMethod.GET)
    public String UserInfo(@PathVariable String phone, ModelMap model) {
        UserProfile user = userInfoService.findByPhone(phone);
        model.addAttribute("user", user);
        //   model.addAttribute("edit", true);
        return "userInfo";
    }
}
