package blogabc.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import blogabc.form.FileForm;

public class UploadController extends SimpleFormController {
	private String path;

	public UploadController() {
		setCommandClass(FileForm.class);
	}

	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		FileForm form = (FileForm) command;
		String storedPath = path + System.getProperty("file.separator") + form.getName();
		UploadUtility.updateFile(form.getContents(), storedPath);
		return new ModelAndView(getSuccessView(), "filename", form.getName());
	}

	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}

	public void setPath(String path) {
		this.path = path;
	}
}
