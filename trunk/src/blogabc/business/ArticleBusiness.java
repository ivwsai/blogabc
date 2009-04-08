/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.business;

import java.util.ArrayList;
import blogabc.dao.ArticleDAO;
import blogabc.entity.Article;
import blogabc.entity.User;
import blogabc.home.BlogABCException;

public class ArticleBusiness {

	private ArticleDAO articleDao;
	
	public ArticleDAO getArticleDao() {
		return articleDao;
	}
	
	public void setAriticleDao(ArticleDAO articleDao) {
		this.articleDao = articleDao;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public ArrayList<Article> getUserArticles(User user){
		return getArticleDao().getUserArticles(user); 
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticle(Long id){
		return getArticleDao().find(id);
	}
	
	/**
	 * 
	 * @param article
	 * @return
	 * @throws BlogABCException 
	 */
	public Long publishArticle(Article article) throws BlogABCException{
//		if(article.getUser()==null){
//			throw new BlogABCException("user cannot be null");
//		}
		
		return (Long)getArticleDao().add(article); 
	}
	
	/**
	 * 
	 * @param article
	 * @return
	 */
	public boolean modifyArticle(Article article){
		return getArticleDao().update(article);
	}
	
	/**
	 * 
	 * @param article
	 * @return
	 */
	public boolean removeArticle(Article article){
		return getArticleDao().delete(article);
	}
}
