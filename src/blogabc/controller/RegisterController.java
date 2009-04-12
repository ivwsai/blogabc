package blogabc.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import blogabc.business.UserBusiness;
import blogabc.entity.User;
import blogabc.form.RegisterForm;

public class RegisterController extends SimpleFormController {
	private UserBusiness userBusiness;
	private String photoBaseUrl;
	private String photoWebUrl;
	
	public void setPhotoWebUrl(String photoWebUrl) {
		this.photoWebUrl = photoWebUrl;
	}

	public RegisterController() {
		setCommandClass(RegisterForm.class);
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}
	
	

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		RegisterForm form = (RegisterForm) command;
		User user = new User();
		// TODO validate
		String password = form.getPassword();

		// TODO need to extract form2bean method
		Date now = new Date();
		user.setCreateTime(now);
		user.setUpdateTime(now);
		user.setDescription(form.getDescription());
		user.setEmail(form.getEmail());
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setName(form.getUsername());
		user.setPassword(password);
		user.setPhone(form.getMobile());
		user.setPoint(0);

		Long id = getUserBusiness().register(user);

		if (id > 0) {
			if (form.getFileContents().length > 0) {
				String p=photoBaseUrl + System.getProperty("file.separator")+user.getName().trim()+".jpg";
				String c=photoWebUrl+"\\"+user.getName().trim()+".jpg";
				if (getUserBusiness().updatePhoto(id, form.getFileContents(),p,c)) {
					Map<String,String> model=new HashMap<String,String>();
					model.put("user", user.getName());
					String path=request.getRequestURL().toString();
					path=path.substring(0,path.indexOf("user"));
					path+=user.getPhotoUrl();
					model.put("url", path);
					return new ModelAndView(getSuccessView(),model);
				} else {
					return new ModelAndView(getFormView());
				}
			} else {
				return new ModelAndView(getSuccessView(), "user", user.getName());
			}
		} else {
			return new ModelAndView(getFormView());
		}
	}

	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	public void setPhotoBaseUrl(String photoBaseUrl) {
		this.photoBaseUrl = photoBaseUrl;
	}

}
