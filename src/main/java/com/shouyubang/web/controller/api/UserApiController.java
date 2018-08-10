package com.shouyubang.web.controller.api;

import com.shouyubang.web.model.*;
import com.shouyubang.web.service.*;
import com.shouyubang.web.utils.ApiConstants;
import com.shouyubang.web.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CallService callService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private JobService jobService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StaffInfoService staffInfoService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private AdviceService adviceService;

    @Autowired
    private UserCreditService userCreditService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces="application/json")
    public Account findUserById(@PathVariable Integer id) {
        return accountService.findOne(id);
    }

    @RequestMapping(value = "/register", method= RequestMethod.POST, consumes="application/json")
    public Response register(@RequestBody Account account) {
        Response response = new Response(1,"SUCCESS");
        System.out.print(account.toString());
        accountService.addAccount(account);
        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes="application/json")
    public Response login(@RequestBody Account account) {
        System.out.print("account "+ account.getPhone()+" login");
        return accountService.validateAccount(account.getPhone(), account.getPassword());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST, consumes="application/json")
    public Response logout(@RequestBody Account account) {
        System.out.print("account "+ account.getPhone()+" logout");
        return accountService.checkoutAccount(account.getPhone());
    }


    @RequestMapping(value = "/call/online", method = RequestMethod.GET, produces="application/json")
    public Response getOnlineStaffList() { //id是用户标识
        List<StaffProfile> staffs = staffInfoService.getAllStaffs();
        Response response = new Response(20, "SUCCESS");
        String jsonArray = JsonUtil.toJSon(staffs);
        response.setData(jsonArray);
        return response;
    }

    @RequestMapping(value = "/call/start", method = RequestMethod.GET, produces = "application/json")
    public Response startCall(@RequestParam(name = "num") String callNum) {
        return callService.startCall(callNum);
    }

    @RequestMapping(value = "/call/comment", method = RequestMethod.POST, consumes="application/json")
    public Response comment(@RequestBody Comment comment) {
        System.out.print("user "+comment.getUserId()+" comment call service");
        return callService.submitComment(comment);
    }

    @RequestMapping(value = "/video/upload", method = RequestMethod.POST, consumes="application/json")
    public Response uploadVideo(@RequestBody Video video) {
        System.out.print("user "+video.getUserId()+" time "+video.getUploadTime().toString()+" upload video");
        return videoService.uploadVideo(video);
    }

    @RequestMapping(value = "/video/list/{id}", method = RequestMethod.GET, produces="application/json")
    public Response getVideos(@PathVariable String id) { //id是用户标识
        List<Video> videos = videoService.getVideosByUserId(id);
        Response response = new Response(12, "SUCCESS");
        String jsonArray = JsonUtil.toJSon(videos);
        response.setData(jsonArray);
        return response;
    }

    @RequestMapping(value = "/video/unread/{id}", method = RequestMethod.GET, produces="application/json")
    public Response countUnreadVideos(@PathVariable String id) {
        Long unread = videoService.countUnreadVideos(id);
        Response response = new Response(14, "SUCCESS");
        response.setData(String.valueOf(unread));
        return response;
    }

    @RequestMapping(value = "/job/list", method = RequestMethod.GET, produces="application/json")
    public Response getJobs(@RequestParam(name = "id") String userId,
                            @RequestParam(name = "type") Integer type) { //id是职位标识
        List<Job> jobs = jobService.getJobsByType(type);
        Response response = new Response(15, "SUCCESS");
        String jsonArray = JsonUtil.toJSon(jobs);
        response.setData(jsonArray);
        return response;
    }

    @RequestMapping(value = "/job", method = RequestMethod.GET, produces="application/json")
    public Response getJob(@RequestParam(name = "id") String userId,
                           @RequestParam(name = "job") Integer jobId) { //id是职位标识
        return jobService.getJob(userId, jobId);
    }

    @RequestMapping(value = "/job/apply", method = RequestMethod.GET, produces="application/json")
    public Response applyJob(@RequestParam(name = "id") String userId,
                             @RequestParam(name = "job") Integer jobId) {
        Response response = new Response(21, "SUCCESS");
        applicationService.addApplication(userId, jobId);
        return response;
    }

    @RequestMapping(value = "/job/applications/{id}", method = RequestMethod.GET, produces="application/json")
    public Response getApplications(@PathVariable String id) { //id是用户标识
        List<Application> applications = applicationService.getApplications(id);
        Response response = new Response(27, "SUCCESS");
        String jsonArray = JsonUtil.toJSon(applications);
        response.setData(jsonArray);
        return response;
    }

    @RequestMapping(value = "/job/mark", method = RequestMethod.GET, produces="application/json")
    public Response markJob(@RequestParam(name = "id") String userId,
                            @RequestParam(name = "job") Integer jobId) {
        Response response = new Response(22, "SUCCESS");
        collectionService.addCollection(userId, jobId);
        return response;
    }

    @RequestMapping(value = "/job/unmark", method = RequestMethod.GET, produces="application/json")
    public Response unmarkJob(@RequestParam(name = "id") String userId,
                              @RequestParam(name = "job") Integer jobId) {
        Response response = new Response(23, "SUCCESS");
        collectionService.updateCollection(userId, jobId, ApiConstants.JOB_UNMARK);
        return response;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST, consumes="application/json")
    public Response addProfile(@RequestBody UserProfile userProfile) {
        Response response = new Response(17,"SUCCESS");
        System.out.print(userProfile.toString());
        userInfoService.addUserInfo(userProfile);
        return response;
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.GET, produces="application/json")
    public Response updateProfile(@RequestParam(name = "id") String userId,
                                  @RequestParam(name = "nickname") String nickname,
                                  @RequestParam(name = "sign") String sign) {
        Response response = new Response(29,"SUCCESS");
        userInfoService.updateUserBasicInfo(userId, nickname,sign);
        return response;
    }

    @RequestMapping(value = "/profile/avatar", method = RequestMethod.GET, produces="application/json")
    public Response updateAvatar(@RequestParam(name = "id") String userId,
                                 @RequestParam(name = "avatar") String avatarUrl) {
        Response response = new Response(18,"SUCCESS");
        userInfoService.updateUserAvatar(userId, avatarUrl);
        return response;
    }


    @RequestMapping(value = "/profile/{id}", method= RequestMethod.GET, produces="application/json")
    public Response getProfile(@PathVariable String id) { //id是用户标识
        Response response = new Response(19, "SUCCESS");
        UserProfile userProfile = userInfoService.getUserInfo(id);
        if(null == userProfile) {
            response.setCode(-1);
            response.setMessage("该用户未填写资料");
        }
        String json = JsonUtil.toJSon(userProfile);
        response.setData(json);
        return response;
    }

    @RequestMapping(value = "/advice", method= RequestMethod.POST, consumes="application/json")
    public Response advice(@RequestBody Advice advice) {
        Response response = new Response(102,"SUCCESS");
        System.out.print(advice.toString());
        adviceService.addAdvice(advice);
        return response;
    }

    @RequestMapping(value = "/credit/{userId}", method= RequestMethod.GET, produces="application/json")
    public Response getCredit(@PathVariable String userId) { //id是用户标识
        Response response = new Response(107, "SUCCESS");
        UserCredit userCredit = userCreditService.getUserCredit(userId);
        String json = JsonUtil.toJSon(userCredit);
        response.setData(json);
        System.out.print(userCredit.toString());
        return response;
    }

}
