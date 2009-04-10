/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.business;

import java.util.ArrayList;

import blogabc.dao.UserDAO;
import blogabc.entity.User;

public class UserBusiness {

	public UserBusiness(){}
	
	private UserDAO userDao;

	public UserBusiness(UserDAO userDao) {
		this.userDao=userDao;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	/**
	 * @param user
	 * @return �û���id
	 */
	public Long register(User user) {
		boolean isExist= isExist(user.getName());
		if(isExist)
			return -1l;
		try {
			Long userId = (Long) getUserDao().add(user);
			return userId;
		} catch (Exception e) {
			return -1l;
		}
	}
	
	public boolean isExist(String username){
		boolean isExist= getUserDao().isExist(username);
		return isExist;
	}

	/**
	 * ��¼
	 * @param userId �û���
	 * @param password ����
	 * @return �û�����
	 */
	public User login(String userId, String password) {
		User user = getUserDao().get(userId, password);
		return user;
	}

	/**
	 * @param userId �û�id
	 * @return �û�����
	 * @throws Exception
	 */
	public User getUser(Long userId){
		User user = getUserDao().find(userId);
		return user;
	}

	public ArrayList<User> getTop10Users(){
		ArrayList<User> list= getUserDao().getTop10Users();
		return list;
	}
}
