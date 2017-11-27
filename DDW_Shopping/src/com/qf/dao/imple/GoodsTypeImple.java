package com.qf.dao.imple;

import java.util.List;

import com.qf.dao.GoodsTypeDao;
import com.qf.domain.GoodsType;
import com.qf.utils.DbHelp;

public class GoodsTypeImple  implements GoodsTypeDao{

	@Override
	public List<GoodsType> queryAll() {
	String sql="select t.*,t1.name pname from tb_goods_type t left join tb_goods_type t1 on t.Parent=t1.id where t.parent=0";
		return DbHelp.queryAll(sql, GoodsType.class);
	}

}
