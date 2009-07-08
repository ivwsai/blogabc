package blogabc.controller.specialtalk;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class AddFeedbackController implements Controller {
	private String viewPage1;
	private String viewPage2;
	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}
	
	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Long sessionId = (Long) request.getSession().getAttribute("userId");
			Long talkId=Long.parseLong(request.getParameter("tid"));
			Map model = new HashMap();		
			model.put("userId", sessionId);
			model.put("talkId", talkId);
			return new ModelAndView(viewPage1,model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}

	public String getViewPage1() {
		return viewPage1;
	}

	public String getViewPage2() {
		return viewPage2;
	}
}