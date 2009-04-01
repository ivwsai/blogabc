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
public class Classify {
	@Id
	private Long id;
	private String name;
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne()
	@JoinColumn(name = "User", referencedColumnName = "id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
