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
	private SpecialTalkDAO specialTalkDao;

	public SpecialTalkDAO getSpecialTalkDao() {
		return specialTalkDao;
	}

	public void setSpecialTalkDao(SpecialTalkDAO specialTalkDao) {
		this.specialTalkDao = specialTalkDao;
	}

	/**
	 * ��ȡר���б�
	 * 
	 * @return
	 */
	public ArrayList<SpecialTalk> getSpecialTalks() {
		return getSpecialTalkDao().getSpecialTalks();
	}

	/**
	 * ����ר��
	 * 
	 * @param SpecialTalk
	 * @return
	 * @throws BlogABCException
	 */
	public Long publishSpecialTalk(SpecialTalk specialTalk) throws BlogABCException {
		return (Long) getSpecialTalkDao().add(specialTalk);
	}

	/**
	 * �޸�ר��
	 * 
	 * @param SpecialTalk
	 * @return
	 */
	public boolean modifySpecialTalk(SpecialTalk specialTalk) {
		return getSpecialTalkDao().update(specialTalk);
	}

	/**
	 * ɾ��ר��
	 * 
	 * @param SpecialTalk
	 * @return
	 */
	public boolean removeSpecialTalk(SpecialTalk specialTalk) {
		return getSpecialTalkDao().delete(specialTalk);
	}

	public SpecialTalk getLastTalk() {
		return getSpecialTalkDao().getLastTalk();
	}

	public SpecialTalk getSpecialTalk(Long talkId) {
		return getSpecialTalkDao().find(talkId);
	}
}
