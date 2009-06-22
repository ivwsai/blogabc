/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller.blog;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import blogabc.business.ArticleBusiness;
import blogabc.business.UserBusiness;
import blogabc.controller.ControllerHelp;
import blogabc.entity.Article;
import blogabc.entity.User;
import blogabc.form.BlogForm1;

public class BlogEditedController extends SimpleFormController {
	private ArticleBusiness articleBusiness;
	private UserBusiness userBusiness;
	private String viewPage1;
	private String viewPage2;
	
	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}
	
	public ArticleBusiness getArticleBusiness() {
		return articleBusiness;
	}

	public void setArticleBusiness(ArticleBusiness articleBusiness) {
		this.articleBusiness = articleBusiness;
	}

	public BlogEditedController() {
		setCommandClass(BlogForm1.class);
	}

	@SuppressWarnings("unchecked")
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		try {
			BlogForm1 form = (BlogForm1) command;
			Long userId = form.getUserId();
			String title = form.getTitle1();
			String content = form.getContent();
			Long cId = form.getClassifyId();
			Long articleId=form.getArticleId();
			
			Article article =  getArticleBusiness().getArticle(articleId);
			article.setClassifyId(cId);
			article.setContent(content);
			article.setTitle(title);
			Date date = new Date();
			article.setUpdateTime(date);
			getArticleBusiness().modifyArticle(article);

			BlogModel blogModel = getArticleBusiness().getArticles(userId, 0, 25);
			User user = getUserBusiness().getUser(userId);
			
			Map model = ControllerHelp.user2model(request, user);
			model.put("user", user.getName());
			model.put("userId", user.getId()+"");		
			model.put("blogModel", blogModel);
			Long sessionId=(Long) request.getSession().getAttribute("userId");		
			boolean isOwn;
			if(sessionId==null){
				isOwn=false;
			}else
				isOwn=sessionId.equals(user.getId());
			model.put("isOwn", isOwn+"");
			return new ModelAndView(viewPage1, model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}
}
