package blogabc.controller;

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
		
		String userId=form.getUsername();
		String password=form.getPassword();
		
		User user=getUserBusiness().login(userId, password);

		if (user!=null) {
			request.getSession().setAttribute("userId", user.getId());
			return new ModelAndView(getSuccessView(), "user", user.getName());
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
