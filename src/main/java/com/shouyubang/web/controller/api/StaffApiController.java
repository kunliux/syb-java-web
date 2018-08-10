package com.shouyubang.web.controller.api;

import com.shouyubang.web.model.*;
import com.shouyubang.web.service.AccountService;
import com.shouyubang.web.service.CallService;
import com.shouyubang.web.service.StaffInfoService;
import com.shouyubang.web.service.VideoService;
import com.shouyubang.web.utils.ApiConstants;
import com.shouyubang.web.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/staff")
public class StaffApiController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CallService callService;

    @Autowired
    private StaffInfoService staffInfoService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public Response register(@RequestBody Account account) {
        Response response = new Response(1,"SUCCESS");
        System.out.print(account.toString());
        accountService.addAccount(account);
        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public Response login(@RequestBody Account account) {
        System.out.print("account "+ account.getPhone()+" login");
        return accountService.validateAccount(account.getPhone(), account.getPassword());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = "application/json")
    public Response logout(@RequestBody Account account) {
        System.out.print("account "+ account.getPhone()+" logout");
        return accountService.updateStaffStatus(account.getPhone(), ApiConstants.CALL_OFFLINE);
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET, produces = "application/json")
    public Response change(@RequestParam(name = "id") String staffId,
                           @RequestParam(name = "status") Integer status){
        return accountService.updateStaffStatus(staffId, status);
    }

    @RequestMapping(value = "/call/accept", method = RequestMethod.GET, produces = "application/json")
    public Response acceptCall(@RequestParam(name = "callId") String callId,
                               @RequestParam(name = "caller") String callerId,
                               @RequestParam(name = "answer") String answerId) {
        return callService.acceptCall(callId, callerId, answerId);
    }

    @RequestMapping(value = "/call/end", method = RequestMethod.GET, produces = "application/json")
    public Response endCall(@RequestParam(name = "callId") String callId,
                            @RequestParam(name = "caller") String callerId,
                            @RequestParam(name = "answer") String answerId) {
        return callService.endCall(callId, callerId, answerId);
    }

    @RequestMapping(value = "/call/comments/{id}", method = RequestMethod.GET, produces = "application/json")
    public Response getComments(@PathVariable String id) {
        List<Comment> comments = callService.getCommentsByStaffId(id);
        Response response = new Response(10, "SUCCESS");
        String jsonArray = JsonUtil.toJSon(comments);
        response.setData(jsonArray);
        return response;
    }


    @RequestMapping(value = "/video/todo", method = RequestMethod.GET, produces = "application/json")
    public Response getToDoTasks() {
        List<Video> videos = videoService.getVideosByStatus(ApiConstants.VIDEO_PRE_SERVICE);
        Response response = new Response(13, "SUCCESS");
        String jsonArray = JsonUtil.toJSon(videos);
        response.setData(jsonArray);
        return response;
    }

    @RequestMapping(value = "/video/list/{id}", method = RequestMethod.GET, produces = "application/json")
    public Response getTasks(@PathVariable String id) {
        List<Video> videos = videoService.getVideosByStaffId(id);
        Response response = new Response(10, "SUCCESS");
        String jsonArray = JsonUtil.toJSon(videos);
        response.setData(jsonArray);
        return response;
    }

    @RequestMapping(value = "/video/reply", method = RequestMethod.POST, consumes = "application/json")
    public Response replyVideo(@RequestBody Video video) {
        System.out.print("staff "+video.getStaffId()+" time "+video.getReplyTime().toString()+" reply video");
        return videoService.replyVideo(video);
    }

    @RequestMapping(value = "/profile/update", method = RequestMethod.POST, consumes="application/json")
    public Response updateProfile(@RequestBody StaffProfile staff) {
        Response response = new Response(29,"SUCCESS");
        staffInfoService.updateStaffInfo(staff);
        return response;
    }

    @RequestMapping(value = "/profile/avatar", method = RequestMethod.GET, produces="application/json")
    public Response updateAvatar(@RequestParam(name = "id") String userId,
                                 @RequestParam(name = "avatar") String avatarUrl) {
        Response response = new Response(18,"SUCCESS");
        staffInfoService.updateStaffAvatar(userId, avatarUrl);
        return response;
    }

    @RequestMapping(value = "/profile/{id}", method= RequestMethod.GET, produces="application/json")
    public Response getProfile(@PathVariable String id) { //id是用户标识
        Response response = new Response(19, "SUCCESS");
        StaffProfile profile = staffInfoService.getStaffInfo(id);
        if(null == profile) {
            response.setCode(-1);
            response.setMessage("该客服不存在");
        }
        String json = JsonUtil.toJSon(profile);
        response.setData(json);
        return response;
    }

}
