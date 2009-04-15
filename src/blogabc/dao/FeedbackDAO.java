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

import blogabc.entity.Article;
import blogabc.entity.Feedback;

public class FeedbackDAO extends BaseDAO {

	public Serializable add(Feedback feedback) {
		try {
			session = getSession();
			Serializable feedbackId = session.save(feedback);
			session.close();
			return feedbackId;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Feedback> findFeedbacks(Article article) {
		String hql = "select feedback from Feedback feedback where feedback.article= :article";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setParameter("article", article);
		ArrayList<Feedback> list = (ArrayList<Feedback>) q.list();
		session.close();
		return list;
	}

	public Feedback find(Long id) {
		return (Feedback) find(Feedback.class, id);
	}
}
