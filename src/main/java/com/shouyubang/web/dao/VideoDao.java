package com.shouyubang.web.dao;

import com.shouyubang.web.model.Video;

import java.util.List;

public interface VideoDao {

	Video getVideo(Integer id);

	void saveVideo(Video video);
	
	List<Video> listAllVideos();

	void updateVideo(Video video);

}
