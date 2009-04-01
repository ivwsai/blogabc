package rvblog.business;

import rvblog.dao.ClassifyDAO;
import rvblog.entity.Classify;

public class ClassifyBusiness {

	private ClassifyDAO classifyDao;

	
	public ClassifyDAO getClassifyDao() {
		return classifyDao;
	}

	public void setClassiyDao(ClassifyDAO classifyDao) {
		this.classifyDao = classifyDao;
	}

	public boolean publishArticle(Classify classify){
		return getClassifyDao().add(classify); 
	}
	
	public boolean modifyArticle(Classify classify){
		return getClassifyDao().update(classify);
	}
	
	public boolean removeArticle(Classify classify){
		return getClassifyDao().delete(classify);
	}
}
