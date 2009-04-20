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

import blogabc.dao.ClassifyDAO;
import blogabc.entity.Classify;
import blogabc.home.BlogABCException;

public class ClassifyBusiness {

	private ClassifyDAO classifyDao;

	public ClassifyDAO getClassifyDao() {
		return classifyDao;
	}

	public void setClassifyDao(ClassifyDAO classifyDao) {
		this.classifyDao = classifyDao;
	}

	public Long createClassify(Classify classify) throws BlogABCException {
		if (classify.getUserId() < 0)
			throw new BlogABCException("user cannot be null");
		return (Long) getClassifyDao().add(classify);
	}

	public boolean modifyClassify(Classify classify) {
		return getClassifyDao().update(classify);
	}

	public boolean removeClassify(Classify classify) {
		return getClassifyDao().delete(classify);
	}

	public Classify getClassify(Long id) {
		Classify classify = getClassifyDao().find(id);
		return classify;
	}

	public ArrayList<Classify> getUserClassify(Long userId) {
		return getClassifyDao().getUserClassify(userId);
	}
}
