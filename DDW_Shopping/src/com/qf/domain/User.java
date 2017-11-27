package com.qf.domain;

import com.qf.annotation.JdbcField;

public class User {

	private int id;// 主键，序号
	private String username;// 昵称
	private String password;// 密码，密文MD5
	private String email;// 邮箱
	// @JdbcField("gender")//注解中写上字段名称
	
	private String gender;// 性别
	
	private String code;// 激活码
	private int flag;// 有效:0未激活，1激活，2无效
	private int role;// 角色：0管理员1会员
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public User( String username, String password, String email, String gender) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.code = code;
		this.flag = flag;
		this.role = role;
	}
	public User() {
		super();
	}
	

}
