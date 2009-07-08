package blogabc.controller.specialtalk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import blogabc.business.SpecialFeedbackBusiness;
import blogabc.business.SpecialTalkBusiness;
import blogabc.entity.SpecialFeedback;
import blogabc.entity.SpecialTalk;
import blogabc.form.FeedBackForm;

public class AddedFeedbackController extends SimpleFormController {
	private String path;
	private SpecialFeedbackBusiness specialFeedbackBusiness;
	private SpecialTalkBusiness specialTalkBusiness;
	private String viewPage1;
	private String viewPage2;
	
	public AddedFeedbackController() {
		setCommandClass(FeedBackForm.class);
	}

	public String getPath() {
		return path;
	}

	public SpecialFeedbackBusiness getSpecialFeedbackBusiness() {
		return specialFeedbackBusiness;
	}

	public SpecialTalkBusiness getSpecialTalkBusiness() {
		return specialTalkBusiness;
	}

	
	@SuppressWarnings("unchecked")
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		try {			
			FeedBackForm form = (FeedBackForm) command;
			SpecialFeedback sf = new SpecialFeedback();
			sf.setContent(form.getContent());
			Long talkId=Long.parseLong(form.getTalkId());
			sf.setSpecialTalkId(talkId);
			
			Long userId = (Long) request.getSession().getAttribute("userId");
			sf.setUserId(userId);

			getSpecialFeedbackBusiness().commitSpecialFeedback(sf);
			
			SpecialTalk talk=getSpecialTalkBusiness().getSpecialTalk(sf.getSpecialTalkId());			
			ArrayList<SpecialFeedback> feedbacks= getSpecialFeedbackBusiness().findSpecialFeedbacks(talkId);
						
			Map model = new HashMap();		
			model.put("talk", talk);
			model.put("feedbacks", feedbacks);
			
			return new ModelAndView(viewPage1,model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setSpecialFeedbackBusiness(
			SpecialFeedbackBusiness specialFeedbackBusiness) {
		this.specialFeedbackBusiness = specialFeedbackBusiness;
	}

	public void setSpecialTalkBusiness(SpecialTalkBusiness specialTalkBusiness) {
		this.specialTalkBusiness = specialTalkBusiness;
	}

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}
}