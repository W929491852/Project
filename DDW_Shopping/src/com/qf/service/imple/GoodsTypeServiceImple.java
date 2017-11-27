package com.qf.service.imple;

import java.util.List;

import com.qf.dao.GoodsTypeDao;
import com.qf.dao.imple.GoodsTypeImple;
import com.qf.domain.GoodsType;
import com.qf.service.GoodsTypeService;

public class GoodsTypeServiceImple  implements GoodsTypeService{
                private GoodsTypeDao dao=new GoodsTypeImple();
	@Override
	public List<GoodsType> queryAll() {
		
		return dao.queryAll();
	}

}
