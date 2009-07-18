/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.dbconnect;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static String CONFIG_FILE_LOCATION = "/Hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration configuration = new AnnotationConfiguration();
	private static org.hibernate.SessionFactory sessionFactory;
	private static String configFile = CONFIG_FILE_LOCATION;

	private HibernateUtil() {
	}

	public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null)? sessionFactory.openSession() : null;
			threadLocal.set(session);
		}

		return session;
	}

	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);

		if (session != null) {
			session.close();
		}
	}

	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setConfigFile(String configFile) {
		HibernateUtil.configFile = configFile;
		sessionFactory = null;
	}

	public static Configuration getConfiguration() {
		return configuration;
	}
}