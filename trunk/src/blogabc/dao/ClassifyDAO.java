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
import org.hibernate.Transaction;

import blogabc.entity.Classify;

public class ClassifyDAO extends BaseDAO {

	public Serializable add(Classify classify) {
		try {
			session = getSession();
			Transaction tran = session.beginTransaction();
			Serializable classId = session.save(classify);
			tran.commit();
			session.close();
			return classId;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean update(Classify classify) {
		try {
			session = getSession();
			Transaction tran = session.beginTransaction();
			session.update(classify);
			tran.commit();
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<Classify> getUserClassify(Long userId) {
		String hql = "select classify from Classify classify where classify.userId= :userId order by classify.id desc";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setParameter("userId", userId);
		ArrayList<Classify> list = (ArrayList<Classify>) q.list();
		session.close();
		return list;
	}

}
