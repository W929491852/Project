package com.qf.dao.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.ResultSetHandler;

import com.qf.dao.*;
import com.qf.domain.*;
import com.qf.utils.DbHelp;

public class OrderDaoImple implements OrderDao{

	@Override
	public boolean save(Order order, List<Cart> list) {
		// TODO Auto-generated method stub
		Map<Object[],String> map=new LinkedHashMap<>();
		//生成订单
		map.put(new Object[]{order.getId(),order.getUid(),order.getMoney(),order.getAid()},"insert into tb_order(id,uid,money,status,time,aid) values(?,?,?,'未支付',now(),?)");
		int i=0;
		//添加订单中的所有商品
		for(Cart cd:list) {
			i++;
			map.put(new Object[]{order.getId(),cd.getPid(),cd.getNum(),cd.getMoney()},"insert into tb_orderdetail(oid,pid,num,money) values(?,?,?,?)");
		}
		//将购物车中的商品删除
		map.put( new Object[]{order.getUid()},"delete from tb_cart where id=?");
		return DbHelp.updateTranaction(map);

	}

	@Override
	public List<Order> queryAll(int uid) {
		// TODO Auto-generated method stub
		return DbHelp.queryAll("select * from tb_order where uid=? ",Order.class, uid);
	}

	@Override
	public OrderDetail queryById(String oid, int uid) {
		// TODO Auto-generated method stub
		String sql="select o.id oid,o.money omoney,o.aid oaid,o.status ostatus,o.time otime,o.uid ouid,a.level alevel,a.name aname,a.phone aphone,a.detail adetail,d.id did,d.money dmoney,d.num dnum,g.id gid,g.name gname,g.price gprice,g.star gstar,g.picture gpicture,g.pubdate gpubdate,t.name typeName from tb_order o left join tb_address a on o.aid=a.id left join tb_orderdetail d on o.id=d.oid left join tb_goods g on g.id=d.pid left join tb_goods_type t on t.id=g.typeid where o.id=? and o.uid=?";
		return DbHelp.queryAll(sql, new ResultSetHandler<OrderDetail>() {

			@Override
			public OrderDetail handle(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				OrderDetail od=new OrderDetail();
				List<OrderItem> list=new ArrayList<>();
				
				int i=0;
				while(rs.next()) {
					++i;
					if(i==1) {
						//订单
						Order order=new Order();
						order.setId(rs.getString("oid"));
						order.setMoney(rs.getInt("omoney"));
						order.setAid(rs.getInt("oaid"));
						order.setStatus(rs.getString("ostatus"));
						order.setTime(rs.getTimestamp("otime"));
						order.setUid(rs.getInt("ouid"));
						od.setOrder(order);
						//地址
						Address address=new Address();
						address.setId(rs.getInt("oaid"));
						address.setLevel(rs.getInt("alevel"));
						address.setName(rs.getString("aname"));
						address.setPhone(rs.getString("aphone"));
						address.setDetail(rs.getString("adetail"));
						address.setUid(rs.getInt("ouid"));
						od.setAddress(address);
					}
					OrderItem item=new OrderItem();
					item.setId(rs.getInt("did"));
					item.setMoney(rs.getInt("dmoney"));
					item.setNum(rs.getInt("dnum"));
					item.setOid(rs.getString("oid"));
					item.setPid(rs.getInt("gid"));
					Goods goods=new Goods();
					goods.setId(rs.getInt("gid"));
					goods.setName(rs.getString("gname"));
					goods.setPicture(rs.getString("gpicture"));
					goods.setPrice(rs.getInt("gprice"));
					goods.setPubdate(rs.getString("gpubdate"));
					goods.setStar(rs.getInt("gstar"));
					goods.setTypeName(rs.getString("typeName"));
					item.setGoods(goods);
					list.add(item);
				}
				od.setList(list);
				return od;
			}
			
		}, oid,uid);
	}
	@Override
	public List<Order> queryAll(String where) {
		// TODO Auto-generated method stub
		String sql="select * from tb_order ";
		if(where.length()>0) {
			sql+=" where "+where;
		}
		sql+=" order by time desc";
		return DbHelp.queryAll(sql, Order.class);
	}

}
