/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller.classify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import blogabc.business.ClassifyBusiness;
import blogabc.business.UserBusiness;
import blogabc.entity.Classify;
import blogabc.entity.User;
import blogabc.form.ClassifyForm;

public class FinishEditClsController extends SimpleFormController {
	private ClassifyBusiness classifyBusiness;
	private UserBusiness userBusiness;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public FinishEditClsController() {
		setCommandClass(ClassifyForm.class);
	}
	
	private String viewPage1;
	private String viewPage2;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}

	public void setClassifyBusiness(ClassifyBusiness classifyBusiness) {
		this.classifyBusiness = classifyBusiness;
	}

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		try {
			ClassifyForm form = (ClassifyForm) command;

			String action = form.getAction();
			String name = form.getName();
			Long userId = form.getUserId();	
			
			if(action.equals("add")){
				Classify classify=new Classify(userId,name);
				classifyBusiness.createClassify(classify);
			}else if(action.equals("edit")){
				Classify classify=classifyBusiness.getClassify(form.getClassifyId());
				classify.setName(name);
				classifyBusiness.modifyClassify(classify);
			}else{
				return new ModelAndView(viewPage2);
			}
			
			ArrayList<Classify> classifies = classifyBusiness.getUserClassify(userId);
			User user = userBusiness.getUser(userId);
			Map model = new HashMap();
			model.put("user", user.getName());
			model.put("userName", user.getFirstName() + " " + user.getLastName());
			model.put("userId", user.getId() + "");
			model.put("classifies", classifies);
			Long sessionId = (Long) request.getSession().getAttribute("userId");
			boolean isOwn;
			if (sessionId == null) {
				isOwn = false;
			} else
				isOwn = sessionId.equals(user.getId());
			model.put("isOwn", isOwn + "");
			return new ModelAndView(viewPage1, model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}
}
