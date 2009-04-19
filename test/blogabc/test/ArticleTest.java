/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: erichan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import blogabc.business.ArticleBusiness;
import blogabc.dao.ArticleDAO;
import blogabc.dao.UserDAO;
import blogabc.entity.Article;
import blogabc.entity.User;
import blogabc.home.BlogABCException;

public class ArticleTest extends TestCase {

	ArticleBusiness ab;
	ArticleDAO articleDao;

	public void testUserArticlesPage() throws BlogABCException {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.get("eric", "1");
		Long userId = user.getId();
		articleDao = new ArticleDAO();
		
		System.out.println("total blog="+articleDao.getTotalCount(userId));
		
		ArrayList<Article> list = articleDao.getUserArticlesPerPage(userId,0,10);
		for (int j = 0; j < list.size(); j++) {
			Article article = list.get(j);
			System.out.println(article.getTitle());
		}
		
		list = articleDao.getUserArticlesPerPage(userId,1,10);
		for (int j = 0; j < list.size(); j++) {
			Article article = list.get(j);
			System.out.println(article.getTitle());
		}
	}
}
