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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户信息类
 * @author luh
 *
 */
@SuppressWarnings("serial")
@Entity
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)   
  	private Long id;	
	private String name;
	private String password;
	/*
	 * 用户积分
	 */
	private int point;	
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
		
	/*
	 * 用户头像照片地址
	 */
	private String photoUrl;	
	/*
	 * 用户自我描述
	 */
	private String description;
	private Date createTime;
	private Date updateTime;

	//没有默认构造子，报错：Javassist Enhancement failed: blogabc.entity.User
	public User(){}
	
	public User(String userId, String password) {
		this.name=userId;
		this.password=password;
	}
	
	public User(String userId, String password,int point) {
		this.name=userId;
		this.password=password;
		this.point=point;
	}

	public User(Long id) {
		this.id=id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
