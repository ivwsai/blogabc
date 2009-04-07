/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: erichan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import blogabc.business.UserBusiness;
import blogabc.dao.UserDAO;
import blogabc.entity.User;

public class UserTest extends TestCase {
	public static void testDAO(){
		UserDAO userDAO = new UserDAO();
		User user = new User("eric1110", "blogabc");

		Long id = (Long) userDAO.add(user);

		user = userDAO.find(id);
		assertNotNull(user);

		user = userDAO.get("eric122", "blogabc");
		assertNotNull(user.getName());
		assertNotNull(user.getPassword());
	}

	public static void testRegister(){
		UserDAO userDAO = new UserDAO();

		User user = new User("eric1111", "blogabc");
		UserBusiness ub = new UserBusiness(userDAO);

		Long userId = ub.register(user);

		user = ub.getUser(userId);
		assertNotNull(user);
		user = ub.login("eric", "blogabc");
		assertNotNull(user.getName());
		assertNotNull(user.getPassword());
	}
	
	public static void testGetTop10(){
		UserDAO userDAO = new UserDAO();
		UserBusiness ub = new UserBusiness(userDAO);
		
		for (int i = 1; i <= 15; i++) {
			User user = new User("eric"+i, "blogabc",i);
			ub.register(user);
		}
		ArrayList<User> list=ub.getTop10Users();
		assertNotNull(list);
		
		
		for (int i = 0; i <= 9; i++) {
			User user = list.get(i);
			assertEquals(user.getName(),"eric"+(15-i));
		}
	}
}
