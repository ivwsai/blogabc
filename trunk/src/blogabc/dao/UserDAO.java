/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.dao;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import blogabc.entity.User;

public class UserDAO extends BaseDAO {

	public Serializable add(User user) {
		try {
			session = getSession();
			Serializable userId = session.save(user);
			session.close();
			return userId;
		} catch (Exception e) {
			return null;
		}
	}

	public User find(Long id) {
		try {
			session = getSession();
			Object result = session.load(User.class, id);
			User user = (User) result;
			Hibernate.initialize(user);
			session.close();
			return user;
		} catch (org.hibernate.ObjectNotFoundException e) {
			return null;
		}
	}

	public User get(String userId, String password) {
		try {
			String hql = "select user from User user where user.name = :name and user.password= :password";
			session = getSession();
			Query q = session.createQuery(hql);
			q.setString("name", userId);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			session.close();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<User> getTop10Users() {
		String hql = "select user from User user order by user.point desc";
		session = getSession();
		Query q = session.createQuery(hql);
		// q.setFirstResult(10);
		q.setMaxResults(10);
		ArrayList<User> list = (ArrayList<User>) q.list();
		session.close();
		return list;
	}

}
