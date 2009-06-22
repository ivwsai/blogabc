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
import org.hibernate.Transaction;

import blogabc.entity.SpecialTalk;

public class SpecialTalkDAO extends BaseDAO {

	@SuppressWarnings("unchecked")
	public ArrayList<SpecialTalk> getSpecialTalks() {
		String hql = "select specialTalk from SpecialTalk specialTalk";
		session = getSession();
		Query q = session.createQuery(hql);
		ArrayList<SpecialTalk> list = (ArrayList<SpecialTalk>) q.list();
		session.close();
		return list;
	}

	public SpecialTalk find(Long id) {
		return (SpecialTalk) find(SpecialTalk.class, id);
	}

	public Serializable add(SpecialTalk specialTalk) {
		try {
			session = getSession();
			Transaction tran = session.beginTransaction();
			Serializable specialTalkId = session.save(specialTalk);
			tran.commit();
			session.close();
			return specialTalkId;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean update(SpecialTalk specialTalk) {
		try {
			session = getSession();
			Transaction tran = session.beginTransaction();
			session.update(specialTalk);
			tran.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(SpecialTalk specialTalk) {
		try {
			session = getSession();
			Transaction tran = session.beginTransaction();
			session.delete(specialTalk);
			tran.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public SpecialTalk getLastTalk() {
		String hql = "select specialTalk from SpecialTalk specialTalk order by specialTalk.id desc";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setMaxResults(1);
		ArrayList<SpecialTalk> list = (ArrayList<SpecialTalk>) q.list();
		session.close();
		if (null != list && list.size() > 0)
			return list.get(0);
		return null;
	}
}