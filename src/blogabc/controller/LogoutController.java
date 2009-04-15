/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import blogabc.business.UserBusiness;

public class LogoutController implements Controller {
	private UserBusiness userBusiness;
	private String viewPage1;

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute("userId", null);
		return new ModelAndView(viewPage1);
	}

}
