/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.tool;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import blogabc.BlogabcApplication;

public class HibernateUtil {
	private SessionFactory sessionFactory;
	
	public HibernateUtil() {
		String rootPath = BlogabcApplication.getInstance().getClassRootPath();
		File file = new File(rootPath+"/Hibernate.cfg.xml");
		try {
			sessionFactory = new AnnotationConfiguration().configure(file).buildSessionFactory();
		} catch (Exception e) {
			String usrDir = System.getProperty("user.dir");
			file = new File(usrDir + "/src/Hibernate.cfg.xml");
			sessionFactory = new AnnotationConfiguration().configure(file).buildSessionFactory();
		}
	}

	public Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
