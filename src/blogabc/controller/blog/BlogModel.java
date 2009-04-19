/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.controller.blog;

import java.io.Serializable;
import java.util.ArrayList;

import blogabc.entity.Article;

@SuppressWarnings("serial")
public class BlogModel implements Serializable {
	private Long belongUserId;
	private ArrayList<Article> blogs;
	private int totalCount;
	private int index;
	private int count;
	private int totalPage;

	public int getTotalPage() {
		if(totalCount%count==0){
			totalPage=totalCount/count;
		}else{
			totalPage=totalCount/count+1;
		}
		return totalPage;
	}

	public BlogModel(Long belongUserId,ArrayList<Article> blogs, int totalCount, int index, int count) {
		this.belongUserId=belongUserId;
		this.blogs = blogs;
		this.totalCount = totalCount;		
		this.index = index;
		this.count = count;
	}

	public ArrayList<Article> getBlogs() {
		return blogs;
	}

	public void setBlogs(ArrayList<Article> blogs) {
		this.blogs = blogs;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getBelongUserId() {
		return belongUserId;
	}

	public void setBelongUserId(Long belongUserId) {
		this.belongUserId = belongUserId;
	}
}
