/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import blogabc.business.UserBusiness;
import blogabc.entity.User;
import blogabc.form.LoginForm;

public class LoginController extends SimpleFormController {
	private UserBusiness userBusiness;

	public LoginController() {
		setCommandClass(LoginForm.class);
	}

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		LoginForm form = (LoginForm) command;

		String userId = form.getUsername();
		String password = form.getPassword();

		User user = getUserBusiness().login(userId, password);

		if (user != null) {
			request.getSession().setAttribute("userId", user.getId());
			Map<String, String> model = ControllerHelp.user2model(request, user);
			return new ModelAndView(getSuccessView(), model);
		} else {
			return new ModelAndView(getFormView());
		}
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}
}
