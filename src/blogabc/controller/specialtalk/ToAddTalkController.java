package blogabc.controller.specialtalk;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import blogabc.business.UserBusiness;
public class ToAddTalkController implements Controller {
	private UserBusiness userBusiness;
	private String viewPage1;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}	
	private String viewPage2;

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Long sessionId = (Long) request.getSession().getAttribute("userId");
			if(userBusiness.isSuper(sessionId))
				return new ModelAndView(viewPage1);
			else
				return new ModelAndView(viewPage2);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public String getViewPage1() {
		return viewPage1;
	}

	public String getViewPage2() {
		return viewPage2;
	}
}