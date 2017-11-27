package com.qf.service.imple;

import java.util.List;

import com.qf.dao.OrderDao;
import com.qf.dao.imple.OrderDaoImple;
import com.qf.domain.Order;
import com.qf.domain.OrderDetail;
import com.qf.domain.Cart;
import com.qf.service.OrderService;

public class OrderServiceImple implements OrderService{
       private OrderDao od=new OrderDaoImple();
	@Override
	public boolean save(Order order, List<Cart> list) {
		// TODO Auto-generated method stub
		return od.save(order, list);
	}

	@Override
	public List<Order> queryAll(int uid) {
		// TODO Auto-generated method stub
		return od.queryAll(uid);
	}

	@Override
	public OrderDetail queryById(String oid, int uid) {
		// TODO Auto-generated method stub
		return od.queryById(oid, uid);
	}
	@Override
	public List<Order> queryAll(String where) {
		// TODO Auto-generated method stub
		return od.queryAll(where);
	}

}
