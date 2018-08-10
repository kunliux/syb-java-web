package com.shouyubang.web.controller.page;

import com.shouyubang.web.model.Application;
import com.shouyubang.web.model.Job;
import com.shouyubang.web.service.ApplicationService;
import com.shouyubang.web.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by SYL on 2017/8/25.
 */
@Controller

public class JobController {


    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicationService applicationService;



    @RequestMapping(value = {"/joblist"}, method = RequestMethod.GET)
    public String listJobs(ModelMap model) {
        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute("jobs", jobs);
        return "allJobs";
    }



    @RequestMapping(value = {"/jobnew"}, method = RequestMethod.GET)
    public String newJob(ModelMap model) {
        Job job = new Job();
        model.addAttribute("job", job);
        model.addAttribute("edit", false);
        return "jobAdd";
    }

    @RequestMapping(value = {"/jobnew"}, method = RequestMethod.POST)
    public String saveJob(@Valid Job job, BindingResult result,
                          ModelMap model) {

        if (result.hasErrors()) {
            return "jobAdd";
        }

		/*
		 * Preferred way to achieve uniqueness of field [idnumber] should be implementing custom @Unique annotation
		 * and applying it on field [idnumber] of Model class [Manager].
		 *
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 *

        if(!jobService.isStaffIdnumberUnique(staff.getId(), staff.getIdnumber())){
            FieldError idnumberError =new FieldError("staff","idnumber",messageSource.getMessage("non.unique.idnumber", new String[]{staff.getIdnumber()}, Locale.getDefault()));
            result.addError(idnumberError);
            return "registration";
        }*/
        else {
            jobService.saveJob(job);
            model.addAttribute("job", true);
            model.addAttribute("success", "工作添加成功");
            return "success";
        }
    }

    /*
     * This method will provide the medium to update an existing staff.
     */
    @RequestMapping(value = {"/edit-{id}-job"}, method = RequestMethod.GET)
    public String editJob(@PathVariable int id, ModelMap model) {
        Job job = jobService.findById(id);
        model.addAttribute("job", job);
        model.addAttribute("edit", true);
        return "jobAdd";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating staff in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-{id}-job"}, method = RequestMethod.POST)
    public String updateJob(@Valid Job job, BindingResult result,
                            ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "jobAdd";
        }
 /*
        if(!jobService.isJobIdnumberUnique(staff.getId(), staff.getIdnumber())){
            FieldError idnumberError =new FieldError("staff","idnumber",messageSource.getMessage("non.unique.idnumber", new String[]{staff.getIdnumber()}, Locale.getDefault()));
            result.addError(idnumberError);
            return "registration";
        }
*/
        jobService.updateJob(job);
        model.addAttribute("job", true);
        model.addAttribute("success", "工作添加成功");
        return "success";
    }


    @RequestMapping(value = {"/deletejob/{id}"}, method = RequestMethod.GET)
    public String deleteJobByID(@PathVariable int id) {
        jobService.deleteJobById(id);
        return "redirect:/joblist";
    }


}
