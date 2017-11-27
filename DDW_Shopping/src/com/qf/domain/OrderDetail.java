package com.qf.domain;

import java.util.List;
//订单详情页准备的类

public class OrderDetail {
	private Order order;
	private Address address;
	private List<OrderItem> list;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<OrderItem> getList() {
		return list;
	}
	public void setList(List<OrderItem> list) {
		this.list = list;
	}
	
}
