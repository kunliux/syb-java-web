package com.shouyubang.web.controller.page;

import com.shouyubang.web.model.Job;
import com.shouyubang.web.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by SYL on 2017/8/30.
 */
@Controller
public class JobDetailController{
        @Autowired
        private JobService jobService;

    @RequestMapping(value = {"jobDetail/{id}"}, method = RequestMethod.GET)
    public String editJob(@PathVariable int id, ModelMap model) {
        Job job = jobService.findById(id);
        model.addAttribute("job", job);
        //   model.addAttribute("edit", true);
        return "jobDetail";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating staff in database. It also validates the user input
     */
//    @RequestMapping(value = {"jobDetail/{id}"}, method = RequestMethod.POST)
//    public String updateJob(@Valid Job job, BindingResult result,
//                             ModelMap model, @PathVariable int id) {
//
//        if (result.hasErrors()) {
//            return "jobDetail";
//        }
// /*
//        if(!jobService.isJobIdnumberUnique(staff.getId(), staff.getIdnumber())){
//            FieldError idnumberError =new FieldError("staff","idnumber",messageSource.getMessage("non.unique.idnumber", new String[]{staff.getIdnumber()}, Locale.getDefault()));
//            result.addError(idnumberError);
//            return "registration";
//        }
//*/
//        jobService.updateJob(job);
//        model.addAttribute("jobsuccess", "Job  updated successfully");
//        return "jobsuccess";
//    }

}
