/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.business;

import blogabc.dao.ClassifyDAO;
import blogabc.entity.Classify;
import blogabc.home.BlogABCException;

public class ClassifyBusiness {

	private ClassifyDAO classifyDao;

	public ClassifyDAO getClassifyDao() {
		return classifyDao;
	}

	public void setClassiyDao(ClassifyDAO classifyDao) {
		this.classifyDao = classifyDao;
	}

	/**
	 * ��������
	 * 
	 * @param classify
	 * @return
	 * @throws BlogABCException
	 */
	public Long createClassify(Classify classify) throws BlogABCException {
		// if(classify.getUser()==null)
		// throw new BlogABCException("user cannot be null");
		return (Long) getClassifyDao().add(classify);
	}

	/**
	 * �޸ķ���
	 * 
	 * @param classify
	 * @return
	 */
	public boolean modifyClassify(Classify classify) {
		return getClassifyDao().update(classify);
	}

	/**
	 * ɾ�����
	 * 
	 * @param classify
	 * @return
	 */
	public boolean removeClassify(Classify classify) {
		return getClassifyDao().delete(classify);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Classify getClassify(Long id) {
		Classify classify = getClassifyDao().find(id);
		return classify;
	}
}
