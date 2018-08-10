package com.shouyubang.web.controller.page;

import com.shouyubang.web.model.Advice;
import com.shouyubang.web.model.News;
import com.shouyubang.web.model.StaffProfile;
import com.shouyubang.web.service.AccountService;
import com.shouyubang.web.service.AdviceService;
import com.shouyubang.web.service.NewsService;
import com.shouyubang.web.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {
	@Autowired
	private StaffInfoService staffService;

	@Autowired
	private NewsService newsService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private AccountService accountService;

	@Autowired
	private AdviceService adviceService;

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home() {
		return "home";
	}


	@RequestMapping(value = { "/advice" }, method = RequestMethod.GET)
	public String advice() {
		return "advice";
	}


	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listStaffs(ModelMap model) {

		List<StaffProfile> staffs = staffService.getAllStaffs();
		model.addAttribute("staffs", staffs);
		return "allstaffs";
	}


	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newStaff(ModelMap model) {
		StaffProfile staff = new StaffProfile();
		model.addAttribute("staff", staff);
		model.addAttribute("edit", false);
		return "addStaff";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveStaff(@Valid StaffProfile staff, BindingResult result,
							ModelMap model) {

		if (result.hasErrors()) {
			return "addStaff";
		}


//		if(!staffService.isStaffIdnumberUnique(staff.getId(), staff.getIdnumber())){
//			FieldError idnumberError =new FieldError("staff","idnumber",messageSource.getMessage("non.unique.idnumber", new String[]{staff.getIdnumber()}, Locale.getDefault()));
//			result.addError(idnumberError);
//			return "registration";
//		}

		staffService.saveStaff(staff);
		model.addAttribute("staff", true);
		model.addAttribute("success", "客服 " + staff.getNickname() + " 添加成功");
		return "success";
	}


	@RequestMapping(value = { "/newsList" }, method = RequestMethod.GET)
	public String listNews(ModelMap model) {

		List<News> newsList = newsService.listAllNews();
		model.addAttribute("newsList", newsList);
		model.addAttribute("newsSize", newsList.size());
		return "allNews";
	}
	@RequestMapping(value = { "/news" }, method = RequestMethod.GET)
	public String news(ModelMap model) {
		News news=new News();
		model.addAttribute("news", news);
//		model.addAttribute("edit", false);
		return "news";
	}

	@RequestMapping(value = { "/news" }, method = RequestMethod.POST)
	public String saveNews(@Valid News news, ModelMap model) {

		newsService.saveNews(news);
		model.addAttribute("news", true);
		model.addAttribute("success", " 新闻添加成功");
		return "success";
	}

	@RequestMapping(value = { "/edit-{id}-news" }, method = RequestMethod.GET)
	public String editNews( ModelMap model,@PathVariable int id) {
		News news = newsService.findById(id);
		model.addAttribute("news", news);
		model.addAttribute("edit", true);
		return "newsDetail";
	}
	@RequestMapping(value = { "/edit-{id}-news" }, method = RequestMethod.POST)
	public String updateNews( @Valid News news, ModelMap model,@PathVariable int id) {

			newsService.updateNews(news);
		    model.addAttribute("news", true);
			model.addAttribute("success", "信息更新成功");
			return "success";
		}

	@RequestMapping(value = { "/deleteNews/{id}" }, method = RequestMethod.GET)
	public String deleteNews(@PathVariable int id) {
		newsService.deleteNews(id);
//		model.addAttribute("edit", true);
		return "redirect:/newsList";
	}


	@RequestMapping(value = { "/edit-{id}-staff" }, method = RequestMethod.GET)
	public String editStaff(@PathVariable int id, ModelMap model) {
		StaffProfile staff = staffService.findById(id);
		model.addAttribute("staff", staff);
		model.addAttribute("edit", true);
		return "addStaff";
	}


	@RequestMapping(value = { "/edit-{id}-staff" }, method = RequestMethod.POST)
	public String updateStaff(@Valid StaffProfile staff, BindingResult result,
                              ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "addStaff";
		}


		staffService.updateStaff(staff);
		model.addAttribute("staff", true);
		model.addAttribute("success", "客服 " + staff.getNickname()	+ " 信息更新成功");
		return "success";
	}



//	@RequestMapping(value = { "/delete-{id}-staff" }, method = RequestMethod.GET)
//	public String deleteStaff(@PathVariable int id) {
//		staffService.deleteStaffById(id);
//		accountService.deleteAccountById(id);
//		return "redirect:/list";
//	}

	@RequestMapping(value = { "/delete-{phone}-staff" }, method = RequestMethod.GET)
	public String deleteStaff(@PathVariable String phone) {
		staffService.deleteStaffInfoByPhone(phone);

		return "redirect:/list";
	}

	@RequestMapping(value = { "/adviceList" }, method = RequestMethod.GET)
	public String listAdvice(ModelMap model) {
		List<Advice> adviceList = adviceService.listAllAdvice();
		model.addAttribute("adviceList", adviceList);
		return "allAdvice";
	}

	@RequestMapping(value = { "/advice/{id}" }, method = RequestMethod.GET)
	public String AdviceDetail(@PathVariable int id, ModelMap model) {
		Advice advice = adviceService.findById(id);
		model.addAttribute("advice", advice);
		return "adviceDetail";
	}

	@RequestMapping(value = { "/advice/{id}" }, method = RequestMethod.POST)
	public String updateAdvice(@Valid Advice advice, BindingResult result,
							  ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "adviceDetail";
		}


		adviceService.updateAdvice(advice);
		model.addAttribute("advice", true);
		model.addAttribute("success","回复成功");
		return "success";
	}

}


