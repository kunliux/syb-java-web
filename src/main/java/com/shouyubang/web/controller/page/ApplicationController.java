package com.shouyubang.web.controller.page;

import com.shouyubang.web.model.Application;
import com.shouyubang.web.service.ApplicationService;
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
 * Created by SYL on 2017/9/14.
 */
@Controller
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = {"/application"}, method = RequestMethod.GET)
    public String Applications(ModelMap model) {
        List<Application> applications = applicationService.getAllApplications();
        model.addAttribute("applications", applications);
        return "allApplication";
    }

    @RequestMapping(value = {"/application/{id}"}, method = RequestMethod.GET)
    public String listApplications(ModelMap model,@PathVariable int id) {
        List<Application> applications = applicationService.getApplicationsById(id);
        model.addAttribute("applications", applications);
        return "allApplication";
    }

    @RequestMapping(value = {"/applicationCheck/job{jobId}/{id}"}, method = RequestMethod.GET)
    public String editApplication(@PathVariable int id,@PathVariable int jobId, ModelMap model) {
        Application application = applicationService.getApplication(id);
        model.addAttribute("application", application);
        model.addAttribute("edit", true);
        return "applicationCheck";
    }
    //
//    /*
//     * This method will be called on form submission, handling POST request for
//     * updating staff in database. It also validates the user input
//     */
    @RequestMapping(value = {"/applicationCheck/job{jobId}/{id}"}, method = RequestMethod.POST)
    public String updateApplication(@Valid Application application, BindingResult result,
                            ModelMap model, @PathVariable int id,@PathVariable int jobId) {

        if (result.hasErrors()) {
            return "applicationCheck";
        }
 /*
        if(!jobService.isJobIdnumberUnique(staff.getId(), staff.getIdnumber())){
            FieldError idnumberError =new FieldError("staff","idnumber",messageSource.getMessage("non.unique.idnumber", new String[]{staff.getIdnumber()}, Locale.getDefault()));
            result.addError(idnumberError);
            return "registration";
        }
*/
        applicationService.updateApplicationProcess(application);
        return "redirect:/application/{jobId}";
    }
}
