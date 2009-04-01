package rvblog.controller;

import rvblog.business.UserBusiness;
import rvblog.entity.User;

public class UserController {

	private UserBusiness userBusiness;
	
	public boolean register(User user){
		return getUserBusiness().register(user);
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}
}
