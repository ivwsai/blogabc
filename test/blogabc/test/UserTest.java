package blogabc.test;

import blogabc.dao.UserDAO;
import blogabc.entity.User;

public class UserTest {

	  public static void main(String[] args) {   
	        UserDAO userDAO = new UserDAO();   
	  
	        User user = new User("eric", "blogabc",0);   
//	        user.setId(1l);   
	        user.setName("eric");   
	        Long userId=(Long)userDAO.add(user);   
	  
	        user = userDAO.find(userId);   
	  
	        System.out.println("name: " + user.getName() +"\tpassword:" + user.getPassword());   
	    } 
}
