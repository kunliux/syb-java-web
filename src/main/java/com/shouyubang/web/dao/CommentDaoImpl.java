package com.shouyubang.web.dao;

import com.shouyubang.web.model.Comment;
import com.shouyubang.web.model.Video;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentDao")
public class CommentDaoImpl extends AbstractDao<Integer, Comment> implements CommentDao {

	public Comment getComment(Integer id) {
		return getByKey(id);
	}

	public void saveComment(Comment comment) {
		persist(comment);
	}

	@SuppressWarnings("unchecked")
	public List<Comment> listAllComments() {
		Criteria criteria = createEntityCriteria();
		return (List<Comment>) criteria.list();
	}

	public void updateComment(Comment comment) {
	    update(comment);
    }

    @SuppressWarnings("unchecked")
    public List<Comment> listCommentsByStaffId(String staffId) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("staffId", staffId))
                .addOrder(Order.desc("time"));
        return (List<Comment>) criteria.list();
    }
}
