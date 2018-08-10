package com.shouyubang.web.service;

import com.shouyubang.web.dao.VideoDaoImpl;
import com.shouyubang.web.model.Video;
import com.shouyubang.web.model.Response;
import com.shouyubang.web.utils.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by KunLiu on 2017/7/25.
 */

@Service
public class VideoService {
    @Autowired
    private VideoDaoImpl videoDao;

    @Transactional
    public Response uploadVideo(Video video) {
        Response response = new Response(8,"SUCCESS");
        String fileId = video.getVideoUrl();
        video.setVideoUrl(ApiConstants.COS_VID_URL+fileId);
        videoDao.saveVideo(video);
        return response;
    }

    @Transactional
    public List<Video> getVideosByUserId(String userId) {
        return videoDao.listVideosByUserId(userId);
    }

    @Transactional
    public List<Video> getVideosByStatus(Integer status) {
        return videoDao.listVideosByStatus(status);
    }

    @Transactional
    public List<Video> getVideosByStaffId(String staffId) {
        return videoDao.listVideosByStaffId(staffId);
    }

    @Transactional
    public long countUnreadVideos(String userId) {
        return videoDao.countUserVideosByStatus(userId, ApiConstants.VIDEO_POST_SERVICE);
    }

    /*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends.
	 */
    @Transactional
    public Response replyVideo(Video video) {
        Response response = new Response(11,"SUCCESS");
        System.out.println(video.toString());
        String fileId = video.getReplyUrl();
        video.setReplyUrl(ApiConstants.COS_VID_URL+fileId);
        video.setStatus(ApiConstants.VIDEO_POST_SERVICE);
        Video entity = videoDao.getVideo(video.getId());
        if(entity!=null){
            entity.setStaffId(video.getStaffId());
            entity.setReplyUrl(video.getReplyUrl());
            entity.setReplyTime(video.getReplyTime());
            entity.setStatus(video.getStatus());
            videoDao.updateVideo(entity);
            return response;
        } else {
            response.setCode(-11);
            response.setMessage("FAIL");
            return response;
        }

    }
}
