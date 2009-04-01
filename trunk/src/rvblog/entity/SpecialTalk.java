/**
 * RVBLOG system
 * 
 * author: EricHan
 * date: 2009-3-30
 */
package rvblog.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class SpecialTalk {
	@Id
	private Long id;
	private String persons;
	public String getPersons() {
		return persons;
	}
	public void setPersons(String persons) {
		this.persons = persons;
	}
	private String introduction;
	private String howto;
	private String attachment;
	private String exercise;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getHowto() {
		return howto;
	}
	public void setHowto(String howto) {
		this.howto = howto;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	private Date createTime;
}
