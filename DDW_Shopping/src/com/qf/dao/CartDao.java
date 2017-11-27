package com.qf.dao;
import java.util.*;

import com.qf.domain.*;

public interface CartDao {
    //添加商品到购物车
	boolean save(Cart cart);
	boolean updateNum(Cart detail);
	//删除购物车的某件商品
	boolean delete(int uid,int pid);
	//清空购物车
	boolean delete(int uid);
	List<Cart> queryAll(int uid);
	//检查指定商品
	Cart querySingle(int uid,int pid);
}
