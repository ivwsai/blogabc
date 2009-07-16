/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.dbconnect;

import java.io.File;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import blogabc.BlogabcApplication;
import blogabc.entity.User;

public class HibernateUtil {
	private SessionFactory sessionFactory;

	public HibernateUtil() {
		String rootPath = BlogabcApplication.getInstance().getClassRootPath();
		File file = new File(rootPath + "/Hibernate.cfg.xml");
		System.out.println("[HibernateUtil-rootPath]:" + rootPath + "/Hibernate.cfg.xml");
		sessionFactory = new AnnotationConfiguration().configure(file).buildSessionFactory();
	}

	public Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}	
	  
	@SuppressWarnings("unchecked")
	public static void main(String[] ss){
		HibernateUtil h=new HibernateUtil();
		Session session=h.sessionFactory.openSession();
		
		String hql = "select user from User user";
		Query q = session.createQuery(hql);
		// q.setFirstResult(10);
		q.setMaxResults(10);
		ArrayList<User> list = (ArrayList<User>) q.list();
		
		System.out.println("print username:");
		for (User user : list) {
			System.out.println(user.getName());
		}
		
		session.close();
	}
}