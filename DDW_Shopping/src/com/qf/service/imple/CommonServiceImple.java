package com.qf.service.imple;

import java.util.List;

import com.qf.dao.CommonDao;
import com.qf.dao.imple.CommonDaoImple;
import com.qf.service.CommonService;

public class CommonServiceImple implements CommonService{
         private CommonDao dao=new CommonDaoImple();
	@Override
	public List<String> getprovince() {
		// TODO Auto-generated method stub
		return dao.getprovince();
	}

	@Override
	public List<String> getcity(String province) {
		// TODO Auto-generated method stub
		return dao.getcity(province);
	}

	@Override
	public List<String> getcounty(String city) {
		// TODO Auto-generated method stub
		return dao.getcounty(city);
	}

}
