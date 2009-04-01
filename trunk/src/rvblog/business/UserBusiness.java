package rvblog.business;

import rvblog.dao.UserDAO;
import rvblog.entity.User;

public class  UserBusiness{

	private UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * ×¢²á
	 * @param user 
	 * @return ÊÇ·ñ×¢²á³É¹¦
	 */
	public boolean register(User user){
		return getUserDao().add(user);
	}
	
	public boolean login(String userId,String password){
		User user=new User(userId,password);
		return getUserDao().get(user);
	}
	
}
