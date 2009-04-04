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
import blogabc.entity.Collect;
import blogabc.entity.User;

public class CollectionDAO extends BaseDAO {
	public Serializable add(Collect collect) {
		try {
			session = getSession();
			Serializable collectId = session.save(collect);
			session.close();
			return collectId;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Collect> findCollects(User user) {
		String hql = "select collect from Collect collect where collect.user= :user";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setParameter("user", user);
		ArrayList<Collect> list = (ArrayList<Collect>) q.list();
		session.close();
		return list;
	}

	public boolean update(Collect collect) {
		try {
			session = getSession();
			session.update(collect);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Collect collect) {
		try {
			session = getSession();
			session.delete(collect);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
