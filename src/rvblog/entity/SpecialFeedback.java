/**
 * RVBLOG system
 * 
 * author: EricHan
 * date: 2009-3-30
 */
package rvblog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SpecialFeedback {
	@Id
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
