/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: erichan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.dao;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Query;

import blogabc.entity.SpecialFeedback;
import blogabc.entity.SpecialTalk;

public class SpecialFeedbackDAO extends BaseDAO {

	public Serializable add(SpecialFeedback specialFeedback) {
		try {
			session = getSession();
			Serializable specialFeedbackId = session.save(specialFeedback);
			session.close();
			return specialFeedbackId;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<SpecialFeedback> findSpecialFeedbacks(SpecialTalk specialTalk) {
		String hql = "select specialFeedback from SpecialFeedback specialFeedback where specialFeedback.specialTalk= :specialTalk";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setParameter("specialTalk", specialTalk);
		ArrayList<SpecialFeedback> list = (ArrayList<SpecialFeedback>) q.list();
		session.close();
		return list;
	}

	public SpecialFeedback find(Long id) {
		return (SpecialFeedback) find(SpecialFeedback.class, id);
	}
}
