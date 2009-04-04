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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class SpecialFeedback implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	private String content;
	private User user;
	private SpecialTalk specialTalk;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@JoinColumn(name = "SpecialTalk", referencedColumnName = "id")
	public SpecialTalk getSpecialTalk() {
		return specialTalk;
	}
	public void setSpecialTalk(SpecialTalk specialTalk) {
		this.specialTalk = specialTalk;
	}
}
