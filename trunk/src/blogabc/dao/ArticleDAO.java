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

import org.hibernate.Query;

import blogabc.entity.Article;
import blogabc.entity.User;

public class ArticleDAO  extends BaseDAO{

	public Serializable add(Article article) {
		try {
			session = getSession();
			Serializable articleId = session.save(article);
			session.close();
			return articleId;
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Article> getUserArticles(User user){
		String hql = "select collect from Collect collect where collect.user= :user";
		session = getSession();
		Query q = session.createQuery(hql);
		q.setParameter("user", user);
		ArrayList<Article> list = (ArrayList<Article>) q.list();
		session.close();
		return list;
	}

	public boolean update(Article article) {
		try {
			session = getSession();
			session.update(article);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delete(Article article) {
		try {
			session = getSession();
			session.delete(article);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
