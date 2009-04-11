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

import blogabc.dao.CollectionDAO;
import blogabc.entity.Collect;

public class CollectionBusiness {

	private CollectionDAO collectionDao;
	
	public CollectionDAO getCollectionDao() {
		return collectionDao;
	}

	public void setCollectionDao(CollectionDAO collectionDao) {
		this.collectionDao = collectionDao;
	}

	/**
	 * ����ղ�
	 * @param collect
	 * @return
	 */
	public Long createCollection(Collect collect){
		return (Long)getCollectionDao().add(collect);
	}
	
	/**
	 * ��ȡ�û����ղ��б�
	 * @param user
	 * @return
	 */
	public ArrayList<Collect> getUserCollects(Long userId){
		return getCollectionDao().findCollects(userId);
		
	}
	
	/**
	 * �޸��ղ�
	 * @param collect
	 * @return
	 */
	public boolean monifyCollection(Collect collect){
		return getCollectionDao().update(collect);
	}
	
	/**
	 * ɾ���ղ�
	 * @param collect
	 * @return
	 */
	public boolean removeCollection(Collect collect){
		return getCollectionDao().delete(collect);
	}
}
