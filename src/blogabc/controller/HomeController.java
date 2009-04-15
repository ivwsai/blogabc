/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import blogabc.business.UserBusiness;
import blogabc.entity.User;

public class HomeController implements Controller {
	private UserBusiness userBusiness;

	private String viewPage1;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public Long register(User user) {
		return getUserBusiness().register(user);
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<User> topUsersList = getUserBusiness().getTop10Users();

		Map<String, ArrayList<User>> model = new HashMap<String, ArrayList<User>>();
		model.put("topUsersList", topUsersList);

		return new ModelAndView(viewPage1, model);
	}

}
