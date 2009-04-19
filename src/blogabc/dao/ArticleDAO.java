/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import blogabc.entity.Article;

public class ArticleDAO extends BaseDAO {

	public Serializable add(Article article) {
		try {
			session = getSession();
			Transaction tran = session.beginTransaction();
			Serializable articleId = session.save(article);
			tran.commit();
			session.close();
			return articleId;
		} catch (Exception e) {
			return null;
		}
	}

	public Article find(Long id) {
		return (Article) find(Article.class, id);
	}
	
	public int upOrdown(Long id,String type){
		if(type.endsWith("up")){
			Article article=(Article) find(Article.class, id);
			int up=article.getUp()+1;
			article.setUp(up);
			update(article);
			return up;
		}else if(type.endsWith("down")){
			Article article=(Article) find(Article.class, id);
			int down=article.getDown()+1;
			article.setDown(down);
			update(article);
			return down;
		}else{
			return -1;
		}
	}
	
	@SuppressWarnings("unchecked")
	public int getTotalCount(Long userId){
		String hql = "select count(article.id) from Article article where article.userId= :userId";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setParameter("userId", userId);
		List list =q.list();
		Long c=(Long)list.get(0);		
		session.close();
		return c.intValue();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Article> getUserArticlesPerPage(Long userId,int page,int perPageCount) {
		String hql = "select article from Article article where article.userId= :userId order by article.id desc";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setParameter("userId", userId);
		int firstResultIndex=page*perPageCount;
		q.setFirstResult(firstResultIndex);
		q.setMaxResults(perPageCount);
		ArrayList<Article> list = (ArrayList<Article>) q.list();
		session.close();
		return list;
	}
	
	/**
	 * get articles by userid and classifyid.
	 * @param userId
	 * @param classifyId
	 * @param page
	 * @param perPageCount
	 * @return list of articles
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Article> getUserArticlesByClassifyPerPage(Long userId,Long classifyId,int page,int perPageCount) {
		String hql = "select article from Article article where article.userId= :userId and article.classifyId=:classifyId order by article.id desc";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setParameter("userId", userId);
		q.setParameter("classifyId", classifyId);
		int firstResultIndex=page*perPageCount;
		q.setFirstResult(firstResultIndex);
		q.setMaxResults(perPageCount);
		ArrayList<Article> list = (ArrayList<Article>) q.list();
		session.close();
		return list;
	}
	
	public boolean update(Article article) {
		try {
			session = getSession();
			Transaction tran = session.beginTransaction();
			session.update(article);
			tran.commit();
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Article article) {
		try {
			session = getSession();
			Transaction tran = session.beginTransaction();
			session.delete(article);
			tran.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
