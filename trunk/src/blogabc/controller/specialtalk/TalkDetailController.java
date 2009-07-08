package blogabc.controller.specialtalk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import blogabc.business.SpecialFeedbackBusiness;
import blogabc.business.SpecialTalkBusiness;
import blogabc.entity.SpecialFeedback;
import blogabc.entity.SpecialTalk;

public class TalkDetailController implements Controller {
	private SpecialTalkBusiness specialTalkBusiness;
	private SpecialFeedbackBusiness specialFeedbackBusiness;
	private String viewPage1;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}	

	public SpecialTalkBusiness getSpecialTalkBusiness() {
		return specialTalkBusiness;
	}

	public void setSpecialTalkBusiness(SpecialTalkBusiness specialTalkBusiness) {
		this.specialTalkBusiness = specialTalkBusiness;
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("id");
		Long talkId =Long.valueOf(id);
		SpecialTalk talk=getSpecialTalkBusiness().getSpecialTalk(talkId);

		ArrayList<SpecialFeedback> feedbacks= getSpecialFeedbackBusiness().findSpecialFeedbacks(talkId);
		Map model = new HashMap();		
		model.put("talk", talk);
		model.put("feedbacks", feedbacks);
		
		return new ModelAndView(viewPage1,model);
	}

	public String getViewPage1() {
		return viewPage1;
	}

	public SpecialFeedbackBusiness getSpecialFeedbackBusiness() {
		return specialFeedbackBusiness;
	}

	public void setSpecialFeedbackBusiness(SpecialFeedbackBusiness specialFeedbackBusiness) {
		this.specialFeedbackBusiness = specialFeedbackBusiness;
	}
}