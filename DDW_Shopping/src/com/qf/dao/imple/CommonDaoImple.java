package com.qf.dao.imple;

import java.util.List;

import com.qf.dao.CommonDao;
import com.qf.utils.DbHelp;

public class CommonDaoImple implements CommonDao{

	@Override
	public List<String> getprovince() {
		// TODO Auto-generated method stub
		return DbHelp.queryAll("select  distinct province from tb_site");
	}

	@Override
	public List<String> getcity(String province) {
		// TODO Auto-generated method stub
		return DbHelp.queryAll("select distinct city from tb_site where province=?", province);
	}

	@Override
	public List<String> getcounty(String city) {
		// TODO Auto-generated method stub
		return DbHelp.queryAll("select  county from tb_site where city=?", city);
	}

}
