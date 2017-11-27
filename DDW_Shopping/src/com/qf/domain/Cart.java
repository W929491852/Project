package com.qf.domain;


public class Cart {
private User user;
private Goods goods;
private int num;
private int money;
private String pname;
private int price;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Goods getGoods() {
	return goods;
}
public void setGoods(Goods goods) {
	this.goods = goods;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}



}
