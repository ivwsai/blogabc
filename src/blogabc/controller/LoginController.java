package blogabc.controller;

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

	
	protected ModelAndView onSubmit(Object command) throws Exception {
		LoginForm form = (LoginForm) command;
		
		String userId=form.getUsername();
		String password=form.getPassword();
		
		User user=getUserBusiness().login(userId, password);

		if (user!=null) {
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
