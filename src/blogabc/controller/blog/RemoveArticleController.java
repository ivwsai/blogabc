package blogabc.controller.blog;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import blogabc.business.ArticleBusiness;
import blogabc.business.UserBusiness;
import blogabc.entity.Article;
import blogabc.entity.User;

public class RemoveArticleController  implements Controller {
	private ArticleBusiness articleBusiness;
	private UserBusiness userBusiness;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	private String viewPage1;
	private String viewPage2;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}

	public void setArticleBusiness(ArticleBusiness articleBusiness) {
		this.articleBusiness = articleBusiness;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String id = request.getParameter("id");
			Long aId = Long.parseLong(id);
			Long sessionId = (Long) request.getSession().getAttribute("userId");

			Article article = articleBusiness.getArticle(aId);
			boolean isRemoved = articleBusiness.removeArticle(article);

			if(isRemoved){
				BlogModel blogModel=articleBusiness.getArticles(sessionId, 0, 25);
				
				User user =userBusiness.getUser(sessionId);
				Map model=new HashMap();
				model.put("user", user.getName());
				model.put("userId", user.getId()+"");		
				model.put("blogModel", blogModel);
				boolean isOwn;
				if(sessionId==null){
					isOwn=false;
				}else
					isOwn=sessionId.equals(user.getId());
				model.put("isOwn", isOwn+"");
				return new ModelAndView(viewPage1, model);
			}			

			return new ModelAndView(viewPage2);
		
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}
}
