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

import blogabc.dao.SpecialTalkDAO;
import blogabc.entity.SpecialTalk;
import blogabc.home.BlogABCException;

public class SpecialTalkBusiness {
private SpecialTalkDAO SpecialTalkDao;
	
	public SpecialTalkDAO getSpecialTalkDao() {
		return SpecialTalkDao;
	}
	
	public void setAriticleDao(SpecialTalkDAO specialTalkDao) {
		this.SpecialTalkDao = specialTalkDao;
	}
	
	/**
	 * 获取专题列表
	 * @return
	 */
	public ArrayList<SpecialTalk> getSpecialTalks(){
		return getSpecialTalkDao().getSpecialTalks(); 
	}
	
	
	/**
	 * 发布专题
	 * @param SpecialTalk
	 * @return
	 * @throws BlogABCException 
	 */
	public Long publishSpecialTalk(SpecialTalk specialTalk) throws BlogABCException{
		return (Long)getSpecialTalkDao().add(specialTalk); 
	}

	/**
	 * 修改专题
	 * @param SpecialTalk
	 * @return
	 */
	public boolean modifySpecialTalk(SpecialTalk specialTalk){
		return getSpecialTalkDao().update(specialTalk);
	}
	
	/**
	 * 删除专题
	 * @param SpecialTalk
	 * @return
	 */
	public boolean removeSpecialTalk(SpecialTalk specialTalk){
		return getSpecialTalkDao().delete(specialTalk);
	}
}
