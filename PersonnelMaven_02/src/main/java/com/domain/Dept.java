package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_dept")
public class Dept {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//序号
	@Column(length=16)
	private String name;//名称
	@Column(length=16)
	private String remark;//说明
	public Dept() {
		super();
	}
	public Dept(int id) {
		super();
		this.id = id;
	}
	public Dept(int id, String name, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
