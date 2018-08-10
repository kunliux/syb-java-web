package com.shouyubang.web.dao;

import com.shouyubang.web.model.Conversation;

import java.util.List;

public interface CallDao {

	Conversation getCall(Integer id);

	void saveCall(Conversation conversation);
	
	List<Conversation> listAllCalls();

	void updateCall(Conversation conversation);

}
