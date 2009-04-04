/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: erichan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.business;

import java.util.ArrayList;

import blogabc.dao.NewsDAO;
import blogabc.entity.News;

public class NewsBusiness {
	private NewsDAO newsDao;
	
	public NewsDAO getNewsDao() {
		return newsDao;
	}
	
	public void setNewsDao(NewsDAO newsDao) {
		this.newsDao = newsDao;
	}
	
	public Long commitNews(News news){
		return (Long)getNewsDao().add(news);
	}
	
	public ArrayList<News> getTop10News(){
		return getNewsDao().getTop10News();
	}
	
	public boolean modifyNews(News news){
		return getNewsDao().update(news);
	}
}
