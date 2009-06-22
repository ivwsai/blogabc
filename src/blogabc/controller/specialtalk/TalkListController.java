package blogabc.controller.specialtalk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import blogabc.business.SpecialTalkBusiness;
import blogabc.entity.SpecialTalk;
import blogabc.tool.StringUtility;

public class TalkListController implements Controller {
	private SpecialTalkBusiness specialTalkBusiness;
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
		ArrayList<SpecialTalk> talkList=getSpecialTalkBusiness().getSpecialTalks();
		Map model = new HashMap();		
		model.put("talkList", talkList);
		
		for(SpecialTalk talk:talkList){
			StringUtility.changeLength(talk.getIntroduction(),20);
		}
		return new ModelAndView(viewPage1,model);
	}

	public String getViewPage1() {
		return viewPage1;
	}
}