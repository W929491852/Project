package com.qf.dao.imple;

import java.util.List;
import com.qf.dao.CartDao;
import com.qf.domain.*;
import com.qf.utils.DbHelp;

public class CartDaoImple implements CartDao{

	@Override
	public boolean save(Cart cart1) {
		// TODO Auto-generated method stub
		return DbHelp.update("insert into tb_cart (id,pid,num,money) values(?,?,?,?)",
				cart1.getId(),cart1.getPid(),cart1.getNum(),cart1.getMoney());
	}

	@Override
	public boolean updateNum(Cart cart1) {
		// TODO Auto-generated method stub
		System.out.println(cart1.getId()+"--->"+cart1.getPid()+"----->"+cart1.getNum()+"--->"+cart1.getMoney());
		return DbHelp.update("update tb_cart set num=?,money=? where id=? and pid=?", 
				cart1.getNum(),cart1.getMoney(),cart1.getId(),cart1.getPid());
	}
	
	@Override
	public boolean delete(int uid, int pid) {
		// TODO Auto-generated method stub
		return DbHelp.update("delete from tb_cart where id=? and pid=?", uid,pid);
	}

	@Override
	public List<Cart> queryAll(int uid) {
		// TODO Auto-generated method stub
		return DbHelp.queryAll("select c.*,g.name pname,g.price from tb_cart c left join tb_goods g on c.pid=g.id where c.id=?", Cart.class,uid);
	}

	@Override
	public boolean delete(int uid) {
		// TODO Auto-generated method stub
		return DbHelp.update("delete from tb_cart where id=?", uid);
	}

	@Override
	public Cart querySingle(int uid, int pid) {
		// TODO Auto-generated method stub
		return DbHelp.querySingle("select c.*,g.name pname,g.price from tb_cart c left join tb_goods g on c.pid=g.id where c.id=? and c.pid=?", Cart.class, uid,pid);
	}

}
