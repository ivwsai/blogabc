package rvblog.entity;
/**
 * RVBLOG system
 * 
 * author: EricHan
 * date: 2009-3-30
 */

import java.util.Date;
import javax.persistence.*;
@Entity
public class Article {
	@Id
	private Long id;
	private String title;
	private String content;
	private User user;
	private Classify classify;
	private Date createTime;
	private Date updateTime;
	/*
	 * ¶¥¡¢²È
	 */
	private int up;
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	private int down;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@ManyToOne()
	@JoinColumn(name = "User", referencedColumnName = "id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne()
	@JoinColumn(name = "Classify", referencedColumnName = "id")
	public Classify getClassify() {
		return classify;
	}
	public void setClassify(Classify classify) {
		this.classify = classify;
	}
}
