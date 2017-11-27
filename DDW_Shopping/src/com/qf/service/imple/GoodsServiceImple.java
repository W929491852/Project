package com.qf.service.imple;

import java.util.List;

import com.qf.dao.GoodsDao;
import com.qf.dao.imple.GoodsDaoImple;
import com.qf.domain.Goods;
import com.qf.service.GoodsService;

public class GoodsServiceImple implements GoodsService{
         private GoodsDao dao=new GoodsDaoImple();
	@Override
	public boolean save(Goods goods) {
		// TODO Auto-generated method stub
		return dao.save(goods);
	}

	@Override
	public boolean update(String set, int id) {
		// TODO Auto-generated method stub
		return dao.update(set, id);
	}

	@Override
	public List<Goods> queryAll(int page, int count, String where) {
		// TODO Auto-generated method stub
		int index=page;
		if(page==0||count==0){
			index=-1;
		}
		return dao.queryAll(page, count, where);
	}

	@Override
	public int queryCount(String where) {
		// TODO Auto-generated method stub
		return dao.queryCount(where);
	}

	@Override
	public Goods queryById(int id) {
		// TODO Auto-generated method stub
		return dao.queryById(id);
	}

}
