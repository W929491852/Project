package com.qf.dao;

import java.util.List;

import com.qf.domain.Goods;

public interface GoodsDao {

	boolean save(Goods goods);
	boolean update(String set ,int id);
	List<Goods> queryAll(int page,int count,String where);
	int queryCount(String where);
	Goods queryById(int id);
	
}
