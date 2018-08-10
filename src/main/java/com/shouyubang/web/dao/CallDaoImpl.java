package com.shouyubang.web.dao;

import com.shouyubang.web.model.Conversation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("callDao")
public class CallDaoImpl extends AbstractDao<Integer, Conversation> implements CallDao {

	public Conversation getCall(Integer id) {
		return getByKey(id);
	}

	public void saveCall(Conversation conversation) {
		persist(conversation);
	}

	@SuppressWarnings("unchecked")
	public List<Conversation> listAllCalls() {
		Criteria criteria = createEntityCriteria();
		return (List<Conversation>) criteria.list();
	}

    @SuppressWarnings("unchecked")
    public List<Conversation> listCallsByAnswerId(String answerId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("answerId", answerId));
        return (List<Conversation>) criteria.list();
    }

	public void updateCall(Conversation conversation) {
	    update(conversation);
    }

    public Conversation getCallByCallId(String callId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("callId", callId));
        return (Conversation) criteria.uniqueResult();
    }
}
