/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: erichan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.home;

//import org.apache.log4j.Logger;

public class BlogABCException extends Exception {
	private static final long serialVersionUID = 6980782787786417235L;
//	private Logger logger;
	public BlogABCException(String string) {
		super(string);
//		logger.error(string);
	}

}
