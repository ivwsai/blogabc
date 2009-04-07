/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * BLOG info class
 * @author luh
 *
 */
@SuppressWarnings("serial")
@Entity
public class Article implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	private String title;
	private String content;
	private User user;
	private Classify classify;
	private Date createTime;
	private Date updateTime;
	/*
	 * * 顶  踩
	 */
	private int up=0;
	private int down=0;
	
	public Article(){}
	
	public Article(User user) {
		this.user=user;
	}
	
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
