package com.shouyubang.web.dao;

import com.shouyubang.web.model.Comment;

import java.util.List;

public interface CommentDao {

	Comment getComment(Integer id);

	void saveComment(Comment comment);
	
	List<Comment> listAllComments();

	void updateComment(Comment comment);

}
