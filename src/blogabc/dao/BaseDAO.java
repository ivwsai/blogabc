/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import blogabc.dbconnect.HibernateUtil;

public class BaseDAO {
	protected Session session;

	private HibernateUtil util;

	protected Session getSession() {
		if (util == null)
			util = new HibernateUtil();
		session = util.getSession();
		return session;
	}

	@SuppressWarnings("unchecked")
	protected Object find(Class clazz, Long id) {
		try {
			session = getSession();
			session.flush();
			Object result = session.load(clazz, id);
			Object object = result;
			Hibernate.initialize(object);
			session.close();
			return object;
		} catch (org.hibernate.ObjectNotFoundException e) {
			return null;
		}
	}
}
