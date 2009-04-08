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

import org.hibernate.Hibernate;

import blogabc.entity.Classify;

public class ClassifyDAO extends BaseDAO {

	public Serializable add(Classify classify) {
		try {
			session = getSession();
			Serializable classId = session.save(classify);
			session.close();
			return classId;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean update(Classify classify) {
		try {
			session = getSession();
			session.update(classify);
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Classify classify) {
		try {
			session = getSession();
			session.delete(classify);
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Classify find(Long id) {
		try {
			session = getSession();
			Object result = session.load(Classify.class, id);
			Classify clssify = (Classify) result;
			Hibernate.initialize(clssify);
			session.close();
			return clssify;
		} catch (org.hibernate.ObjectNotFoundException e) {
			return null;
		}
	}

}
