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
import java.util.Date;

import blogabc.controller.blog.BlogModel;
import blogabc.dao.ArticleDAO;
import blogabc.entity.Article;
import blogabc.home.BlogABCException;

public class ArticleBusiness {

	private ArticleDAO articleDao;

	public ArticleDAO getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDAO articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * get articles
	 * 
	 * @param userId
	 * @param page
	 * @param perPageCount
	 * @return
	 */

	public BlogModel getArticles(Long userId, int page, int perPageCount) {
		ArrayList<Article> blogs = getArticleDao().getUserArticlesPerPage(userId, page, perPageCount);
		int totalCount = getArticleDao().getTotalCount(userId);
		int index = page;
		int count = perPageCount;
		BlogModel model = new BlogModel(userId, blogs, totalCount, index, count);
		return model;
	}

	/**
	 * get articles
	 * 
	 * @param userId
	 * @param classifyId
	 * @param page
	 * @param perPageCount
	 * @return
	 */
	public BlogModel getArticlesByClassify(Long userId, Long classifyId, int page, int perPageCount) {
		ArrayList<Article> blogs = getArticleDao().getUserArticlesByClassifyPerPage(userId, classifyId, page, perPageCount);
		int totalCount = getArticleDao().getTotalCount(userId);
		int index = page;
		int count = perPageCount;
		BlogModel model = new BlogModel(userId, blogs, totalCount, index, count);
		return model;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticle(Long id) {
		return getArticleDao().find(id);
	}

	/**
	 * 
	 * @param article
	 * @return
	 * @throws BlogABCException
	 */
	public Long publishArticle(Article article) throws BlogABCException {
		if (article.getUserId() == null) {
			throw new BlogABCException("user cannot be null");
		}

		Date d = new Date();
		article.setCreateTime(d);
		article.setUpdateTime(d);

		return (Long) getArticleDao().add(article);
	}

	/**
	 * 
	 * @param article
	 * @return
	 */
	public boolean modifyArticle(Article article) {
		return getArticleDao().update(article);
	}

	/**
	 * 
	 * @param article
	 * @return
	 */
	public boolean removeArticle(Article article) {
		return getArticleDao().delete(article);
	}

	public void upOrdown(Long articleId, String action) {
		getArticleDao().upOrdown(articleId, action);
	}
	
	public ArrayList<Article> getNewArticles(){
		return getArticleDao().getNewArticles();
	}

	public ArrayList<Article> getHotArticles() {
		return getArticleDao().getHotArticles();
	}
}
