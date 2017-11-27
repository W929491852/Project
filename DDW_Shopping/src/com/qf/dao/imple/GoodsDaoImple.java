package com.qf.dao.imple;

import java.util.List;

import com.qf.dao.GoodsDao;
import com.qf.domain.Goods;
import com.qf.utils.DbHelp;

public class GoodsDaoImple implements GoodsDao{

	@Override
	public boolean save(Goods goods) {
		return DbHelp.update("insert into tb_goods(name,pubdate,price,star,intro,picture,typeid) values(?,?,?,?,?,?,?)", 
				goods.getName(),goods.getPubdate(),goods.getPrice(),goods.getStar(),goods.getIntro(),goods.getPicture(),goods.getTypeid());
	}

	@Override
	public boolean update(String set,int id) {
		// TODO Auto-generated method stub
		return DbHelp.update("update tb_goods set "+set+" where id=?", id);
	}

	@Override
	public List<Goods> queryAll(int index, int count, String where) {
		// TODO Auto-generated method stub
		String sql="select g.*,t.name typeName from tb_goods g left join tb_goods_type t on g.typeid=t.id ";
		if(where.length()>0){
			sql+=" where "+where;
		}
		sql+= " limit ?,?";
		if(index==-1 || count==0){
			index=0;
			count=Integer.MAX_VALUE;
		}
		
		return DbHelp.queryAll(sql, Goods.class, index,count);
	}

	@Override
	public int queryCount(String where) {
		// TODO Auto-generated method stub
		String sql="select COUNT(1) from tb_goods g ";
		if(where.length()>0){
			sql+=" where "+where;
		}
		return DbHelp.queryCount(sql);
	}

	@Override
	public Goods queryById(int id) {
		// TODO Auto-generated method stub
		return DbHelp.querySingle("select g.*,t.name typeName from tb_goods g left join tb_goods_type t on g.typeid=t.id where g.id=? ", Goods.class, id);
	}


}
