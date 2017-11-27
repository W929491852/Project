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
@Table(name="tb_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//主键
	@Column(length=50)
	private String name;//姓名
	@Column(length=100)
	private String cardId;//身份证
	@Column(length=100)
	private String address;//住址
	@Column(length=10)
	private String postCode;//邮编
	@Column(length=11)
	private String tel;//手机号
	@Column(length=15)
	private String phone;//电话
	@Column(length=12)
	private String qqNum;//QQ号
	@Column(length=30)
	private String email;//邮箱
	@Column
	private int sex;//性别
	@Column(length=10)
	private String party;//政治面貌
	@Column
	private Date birthday;//生日
	@Column(length=20)
	private String race;//民族
	@Column(length=10)
	private String education;//学历
	@Column(length=20)
	private String speciality;//专业
	@Column(length=50)
	private String hobby;//爱好
	@Column(length=100)
	private String remark;//备注
	@Column
	private Date createDate;//创建时间
	@ManyToOne(targetEntity=User.class,fetch=FetchType.EAGER)
	@JoinColumn(name="uid")
	private User user;//用户表主键
	@ManyToOne(targetEntity=Dept.class,fetch=FetchType.EAGER)
	@JoinColumn(name="did")
	private Dept dept;//部门表
	@ManyToOne(targetEntity=Job.class,fetch=FetchType.EAGER)
	@JoinColumn(name="jid")
	private Job job;//职位表
	
	
	public Employee(String name, String cardId, String address, String postCode, String tel, String phone, String qqNum,
			String email, int sex, String party, Date birthday, String race, String education, String speciality,
			String hobby, String remark, Date createDate, User user, Dept dept, Job job) {
		super();
		this.name = name;
		this.cardId = cardId;
		this.address = address;
		this.postCode = postCode;
		this.tel = tel;
		this.phone = phone;
		this.qqNum = qqNum;
		this.email = email;
		this.sex = sex;
		this.party = party;
		this.birthday = birthday;
		this.race = race;
		this.education = education;
		this.speciality = speciality;
		this.hobby = hobby;
		this.remark = remark;
		this.createDate = createDate;
		this.user = user;
		this.dept = dept;
		this.job = job;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee() {
		super();
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
	
	
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQqNum() {
		return qqNum;
	}
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	
}
