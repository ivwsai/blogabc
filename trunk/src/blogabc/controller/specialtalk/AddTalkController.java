package blogabc.controller.specialtalk;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import blogabc.business.SpecialTalkBusiness;
import blogabc.entity.SpecialTalk;
import blogabc.form.TalkForm;
import blogabc.tool.UploadUtility;

public class AddTalkController extends SimpleFormController {
	private String viewPage1;
	private String viewPage2;
	private String path;
	private SpecialTalkBusiness specialTalkBusiness;

	public AddTalkController() {
		setCommandClass(TalkForm.class);
	}

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}

	@SuppressWarnings("unchecked")
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		try {
			TalkForm form = (TalkForm) command;
			SpecialTalk st = new SpecialTalk();
			st.setPersons(form.getPersons());
			st.setIntroduction(form.getIntroduction());
			st.setHowto(form.getHowto());
			st.setExercise(form.getExercise());
			st.setCreateTime(new Date());
			Long specialTalkId = getSpecialTalkBusiness().publishSpecialTalk(st);

			String contextPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
			
			if (specialTalkId > 0) {
				StringBuilder sb=new StringBuilder();
				if (form.getAttachment1().length > 0) {
					String name=form.getAttachmentName1();
					int index=name.lastIndexOf(System.getProperty("file.separator"));
					String storedPath = path+ System.getProperty("file.separator") +name.substring(index+1);
					UploadUtility.updateFile(form.getAttachment1(), storedPath);
					
					String savePath =contextPath+"/upload/talk/"+name.substring(index+1);
					sb.append(savePath+";");
				}
				if (form.getAttachment2().length > 0) {
					String name=form.getAttachmentName2();
					int index=name.lastIndexOf(System.getProperty("file.separator"));
					String storedPath = path+ System.getProperty("file.separator") +name.substring(index+1);
					UploadUtility.updateFile(form.getAttachment2(), storedPath);

					String savePath =contextPath+"/upload/talk/"+name.substring(index+1);
					sb.append(savePath+";");
				}
				if (form.getAttachment3().length > 0) {
					String name=form.getAttachmentName3();
					int index=name.lastIndexOf(System.getProperty("file.separator"));
					String storedPath = path+ System.getProperty("file.separator") +name.substring(index+1);
					UploadUtility.updateFile(form.getAttachment3(), storedPath);

					String savePath =contextPath+"/upload/talk/"+name.substring(index+1);
					sb.append(savePath+";");
				}
				
				st.setAttachment(sb.toString());
				getSpecialTalkBusiness().modifySpecialTalk(st);
			}
			
			ArrayList<SpecialTalk> talkList=getSpecialTalkBusiness().getSpecialTalks();
			Map model = new HashMap();		
			model.put("talkList", talkList);
			
			return new ModelAndView(viewPage1,model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}

	public SpecialTalkBusiness getSpecialTalkBusiness() {
		return specialTalkBusiness;
	}

	public void setSpecialTalkBusiness(SpecialTalkBusiness specialTalkBusiness) {
		this.specialTalkBusiness = specialTalkBusiness;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}