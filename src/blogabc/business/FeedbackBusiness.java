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

import blogabc.dao.FeedbackDAO;
import blogabc.entity.Article;
import blogabc.entity.Feedback;

public class FeedbackBusiness {
	private FeedbackDAO feedbackDao;
	public FeedbackDAO getFeedbackDao() {
		return feedbackDao;
	}
	public void setFeedbackDao(FeedbackDAO feedbackDao) {
		this.feedbackDao = feedbackDao;
	}
	
	/**
	 * 提交回复
	 * @param feedback
	 * @return
	 */
	public Long commitFeedback(Feedback feedback){
		return (Long)getFeedbackDao().add(feedback);
	}
	
	/**
	 * 获取博文回复列表
	 * @param article
	 * @return
	 */
	public ArrayList<Feedback> getArticleFeedback(Article article){
		return getFeedbackDao().findFeedbacks(article);
	}
	
}
