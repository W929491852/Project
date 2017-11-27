package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_sign")
public class Sign {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//序号
	@Column
	private Date createtime;//时间
	@Column
	private int flag;//1有效，2无效
	@ManyToOne(targetEntity=User.class,fetch=FetchType.EAGER)
	@JoinColumn(name="uid")
	private User user;
	public Sign() {
		super();
	}
	public Sign(Date createtime, int flag, User user) {
		super();
		this.createtime = createtime;
		this.flag = flag;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
