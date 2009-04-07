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

	public void testUserArticles() throws BlogABCException {
		UserDAO userDAO = new UserDAO();
		User user = new User("eric1110", "blogabc");
		userDAO.add(user);

		articleDao = new ArticleDAO();
		ab = new ArticleBusiness();
		ab.setAriticleDao(articleDao);

		for (int j = 0; j < 10; j++) {
			Article article = new Article(user);
			article.setTitle("" + j);
			ab.publishArticle(article);
		}

		ArrayList<Article> list=ab.getUserArticles(user);
		
		for (int j = 0; j < list.size(); j++) {
			Article article = list.get(j);
			assertEquals(article.getTitle(), ""+j);
		}		
	}

	public void testCRUD() throws BlogABCException {
		articleDao = new ArticleDAO();
		ab = new ArticleBusiness();
		ab.setAriticleDao(articleDao);

		Article article = new Article();

		Long aId = ab.publishArticle(article);

		assertNotNull(aId);

		assertNotNull(article);

		boolean isModified = ab.modifyArticle(article);
		assertTrue(isModified);

		boolean isRemoved = ab.removeArticle(article);
		assertTrue(isRemoved);
	}
}
