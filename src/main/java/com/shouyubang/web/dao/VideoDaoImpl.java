package com.shouyubang.web.dao;

import com.shouyubang.web.model.Video;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("videoDao")
public class VideoDaoImpl extends AbstractDao<Integer, Video> implements VideoDao {

	public Video getVideo(Integer id) {
		return getByKey(id);
	}

	public void saveVideo(Video video) {
		persist(video);
	}

	@SuppressWarnings("unchecked")
	public List<Video> listAllVideos() {
		Criteria criteria = createEntityCriteria()
                .addOrder(Order.desc("uploadTime"));
		return (List<Video>) criteria.list();
	}

	public void updateVideo(Video video) {
		update(video);
	}

    @SuppressWarnings("unchecked")
    public List<Video> listVideosByUserId(String userId) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("userId", userId))
                .addOrder(Order.desc("uploadTime"));
        return (List<Video>) criteria.list();
    }

	@SuppressWarnings("unchecked")
	public List<Video> listVideosByStaffId(String staffId) {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eq("staffId", staffId))
				.addOrder(Order.desc("replyTime"));
		return (List<Video>) criteria.list();
	}

    @SuppressWarnings("unchecked")
    public List<Video> listVideosByStatus(Integer status) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("status", status))
                .addOrder(Order.desc("uploadTime"));
        return (List<Video>) criteria.list();
    }

    @SuppressWarnings("unchecked")
	public List<Video> getStaffVideosByStatus(String staffId, Integer status) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("staffId", staffId))
                .add(Restrictions.eq("status", status))
                .addOrder(Order.desc("replyTime"));
        return (List<Video>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Video> listUserVideosByStatus(String userId, Integer status) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("status", status))
                .addOrder(Order.desc("uploadTime"));
        return (List<Video>) criteria.list();
    }

    public long countUserVideosByStatus(String userId, Integer status) {
        return listUserVideosByStatus(userId, status).size();
    }

}
