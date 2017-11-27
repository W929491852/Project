package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//序号
	@Column(length=50)
	private String username;//用户名
	@Column(length=16)
	private String loginname;//登陆名
	@Column(length=32)
	private String password;//密码
	@Column
	private int status;//状态
	@Column
	private Date createdate;//建档日期
	public User() {
		super();
	}
	public User(int id) {
		super();
		this.id = id;
	}
	public User(String username, String loginname, String password, int status, Date createdate) {
		super();
		this.username = username;
		this.loginname = loginname;
		this.password = password;
		this.status = status;
		this.createdate = createdate;
	}
	public User(int id, String username, String loginname, String password, int status, Date createdate) {
		super();
		this.id = id;
		this.username = username;
		this.loginname = loginname;
		this.password = password;
		this.status = status;
		this.createdate = createdate;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
}
