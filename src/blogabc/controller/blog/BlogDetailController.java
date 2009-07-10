/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller.blog;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import blogabc.business.ArticleBusiness;
import blogabc.entity.Article;
import blogabc.tool.StringUtility;

public class BlogDetailController implements Controller {
	private ArticleBusiness articleBusiness;

	public ArticleBusiness getArticleBusiness() {
		return articleBusiness;
	}

	public void setArticleBusiness(ArticleBusiness articleBusiness) {
		this.articleBusiness = articleBusiness;
	}

	private String viewPage1;
	private String viewPage2;

	public void setViewPage1(String viewPage1) {
		this.viewPage1 = viewPage1;
	}

	public void setViewPage2(String viewPage2) {
		this.viewPage2 = viewPage2;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			Long articleId = Long.parseLong(request.getParameter("id"));
			String user = request.getParameter("userId");

			Article article = getArticleBusiness().getArticle(articleId);
//			article.setContent(StringUtility.setBR(article.getContent(), 62));
			Map model = new HashMap();
			model.put("article", article);
			if (null != user) {
				Long userId = Long.parseLong(user);
				model.put("userId", userId);
			}
			return new ModelAndView(viewPage1, model);
		} catch (Exception e) {
			return new ModelAndView(viewPage2);
		}
	}
}