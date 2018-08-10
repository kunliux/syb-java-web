package com.shouyubang.web.service;

import com.shouyubang.web.dao.*;
import com.shouyubang.web.model.Conversation;
import com.shouyubang.web.model.Comment;
import com.shouyubang.web.model.Response;
import com.shouyubang.web.model.Video;
import com.shouyubang.web.utils.ApiConstants;
import com.shouyubang.web.utils.JsonUtil;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by KunLiu on 2017/7/25.
 */

@Service
@ComponentScan("com.shouyubang.web.dao")
public class CallService {

    @Autowired
    private CallDaoImpl callDao;

    @Autowired
    private CommentDaoImpl commentDao;

    @Autowired
    private StaffInfoDaoImpl staffInfoDao;

    @Transactional
    public Response startCall(String callNum) {
        Response response = new Response(24, "SUCCESS");
        if(staffInfoDao.getStaffStatus(callNum) == ApiConstants.CALL_ONLINE) {
            staffInfoDao.updateStaffStatus(callNum, ApiConstants.CALL_BUSY);
            return response;
        } else {
            response.setCode(-1);
            response.setMessage("客服忙碌");
            return response;
        }
    }

    @Transactional
    public Response acceptCall(String callId, String callerId, String answerId) {
        Response response = new Response(28, "SUCCESS");
        Conversation conversation = new Conversation(callId, callerId, answerId);
        conversation.setStartTime(new LocalDateTime());
        System.out.println(conversation.toString());
        callDao.saveCall(conversation);
        return response;
    }

    @Transactional
    public Response endCall(String callId, String callerId, String answerId) {
        Response response = new Response(25, "SUCCESS");
        Conversation conversation = callDao.getCallByCallId(callId);
        conversation.setEndTime(new LocalDateTime());
        callDao.updateCall(conversation);
        staffInfoDao.updateStaffStatus(answerId, ApiConstants.CALL_ONLINE);
        return response;
    }

    @Transactional
    public Response getCallLog(String answerId) {
        Response response = new Response(26, "SUCCESS");
        List<Conversation> conversations = callDao.listCallsByAnswerId(answerId);
        String jsonArray = JsonUtil.toJSon(conversations);
        response.setData(jsonArray);
        return response;
    }

    @Transactional
    public Response submitComment(Comment comment) {
        Response response = new Response(4,"SUCCESS");
        commentDao.saveComment(comment);
        return response;
    }

    @Transactional
    public List<Comment> getCommentsByStaffId(String staffId) {
        return commentDao.listCommentsByStaffId(staffId);
    }
}
