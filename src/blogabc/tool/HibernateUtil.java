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
		File file = new File(rootPath + "/Hibernate.cfg.xml");
		try {
			System.out.println("[HibernateUtil-rootPath]:"+rootPath);
			sessionFactory = new AnnotationConfiguration().configure(file).buildSessionFactory();
		} catch (Exception e) {
			String usrDir = System.getProperty("user.dir");
			String path=usrDir + "/src/Hibernate.cfg.xml";
			System.out.println("[HibernateUtil-userPath]:"+path);
			file = new File(path);
			sessionFactory = new AnnotationConfiguration().configure(file).buildSessionFactory();
		}
	}

	public Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}	
	  
	public static void main(String[] s){
		new HibernateUtil();
		
	}
}
//ALTER DATABASE `blogdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin