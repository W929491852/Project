package com.qf.service;

import java.util.List;

import com.qf.domain.*;
import com.qf.domain.Cart;

public interface CartService {

	boolean save(Cart cart1);
	boolean changeNum(Cart cart1,int type);
	//清空购物车
	boolean delete(int uid);
	List<Cart> queryAll(int uid);
	
}
