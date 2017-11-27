package com.qf.dao;

import java.util.List;

import com.qf.domain.*;

public interface OrderDao {


	//新增订单
	boolean save(Order order,List<Cart> list);
	//获取订单列表
	List<Order> queryAll(int uid);
	
	List<Order> queryAll(String where);
	
	//获取指定订单的详细信息
	OrderDetail queryById(String oid,int uid);
}
