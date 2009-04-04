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
import blogabc.entity.User;

public class CollectionBusiness {

	private CollectionDAO collectionDao;
	
	public CollectionDAO getCollectionDao() {
		return collectionDao;
	}

	public void setCollectionDao(CollectionDAO collectionDao) {
		this.collectionDao = collectionDao;
	}

	/**
	 * 添加收藏
	 * @param collect
	 * @return
	 */
	public Long createCollection(Collect collect){
		return (Long)getCollectionDao().add(collect);
	}
	
	/**
	 * 获取用户的收藏列表
	 * @param user
	 * @return
	 */
	public ArrayList<Collect> getUserCollects(User user){
		return getCollectionDao().findCollects(user);
		
	}
	
	/**
	 * 修改收藏
	 * @param collect
	 * @return
	 */
	public boolean monifyCollection(Collect collect){
		return getCollectionDao().update(collect);
	}
	
	/**
	 * 删除收藏
	 * @param collect
	 * @return
	 */
	public boolean removeCollection(Collect collect){
		return getCollectionDao().delete(collect);
	}
}
