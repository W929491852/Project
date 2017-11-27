package com.qf.service.imple;

import java.util.List;


import com.qf.dao.CartDao;
import com.qf.dao.*;
import com.qf.dao.imple.CartDaoImple;
import com.qf.domain.Cart;
import com.qf.service.CartService;

public class CartServiceImple implements CartService{
	private CartDao dao=new CartDaoImple();
	//添加商品到购物车
	@Override
	public boolean save(Cart detail) {
		// TODO Auto-generated method stub
		Cart cd=dao.querySingle(detail.getId(), detail.getPid());
		if(cd==null) {
			return dao.save(detail);
		}else {
			cd.setNum(cd.getNum()+1);
			cd.setMoney(cd.getNum()*cd.getPrice());
			
		return dao.updateNum(cd);
		}
		}
	@Override
	public boolean delete(int uid) {
		// TODO Auto-generated method stub
		return dao.delete(uid);
	}

	@Override
	public List<Cart> queryAll(int uid) {
		// TODO Auto-generated method stub
		return dao.queryAll(uid);
	}
	//购物车的数量改变：加1、减1、删除
	@Override
	public boolean changeNum(Cart cart1,int type) {
		// TODO Auto-generated method stub
		if(type<3) {
			System.out.println(cart1.getId()+"--->"+cart1.getPid()+"----->"+cart1.getNum()+"--->"+cart1.getMoney());
			return dao.updateNum(cart1);
		}else {
			return dao.delete(cart1.getId(),cart1.getPid());
		}
		
	}

}
