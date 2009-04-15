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

import blogabc.entity.News;

public class NewsDAO extends BaseDAO {

	public Serializable add(News news) {
		try {
			session = getSession();
			Serializable newsId = session.save(news);
			session.close();
			return newsId;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<News> getTop10News() {
		String hql = "select news from News news order by createTime desc";
		session = getSession();
		Query q = session.createQuery(hql);
		ArrayList<News> list = (ArrayList<News>) q.list();
		session.close();
		return list;
	}

	public boolean update(News news) {
		try {
			session = getSession();
			session.update(news);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public News find(Long id) {
		return (News) find(News.class, id);
	}

}
