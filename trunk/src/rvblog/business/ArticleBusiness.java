package rvblog.business;

import rvblog.dao.AriticleDAO;
import rvblog.entity.Article;

public class ArticleBusiness {

	private AriticleDAO ariticleDao;
	public AriticleDAO getAriticleDao() {
		return ariticleDao;
	}
	public void setAriticleDao(AriticleDAO ariticleDao) {
		this.ariticleDao = ariticleDao;
	}
	
	public boolean publishArticle(Article article){
		return getAriticleDao().add(article); 
	}
	
	public boolean modifyArticle(Article article){
		return getAriticleDao().update(article);
	}
	
	public boolean removeArticle(Article article){
		return getAriticleDao().delete(article);
	}
}
