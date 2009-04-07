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

import blogabc.dao.SpecialFeedbackDAO;
import blogabc.entity.SpecialFeedback;
import blogabc.entity.SpecialTalk;

public class SpecialFeedbackBusiness {
	private SpecialFeedbackDAO specialFeedbackDao;
	public SpecialFeedbackDAO getSpecialFeedbackDao() {
		return specialFeedbackDao;
	}
	public void setSpecialFeedbackDao(SpecialFeedbackDAO specialFeedbackDao) {
		this.specialFeedbackDao = specialFeedbackDao;
	}
	
	/**
	 * 提交回复
	 * @param specialFeedback
	 * @return
	 */
	public Long commitSpecialFeedback(SpecialFeedback specialFeedback){
		return (Long)getSpecialFeedbackDao().add(specialFeedback);
	}
	
	/**
	 * 获取博文回复列表
	 * @param article
	 * @return
	 */
	public ArrayList<SpecialFeedback> getArticleSpecialFeedback(SpecialTalk specialTalk){
		return getSpecialFeedbackDao().findSpecialFeedbacks(specialTalk);
	}
}
