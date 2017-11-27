package com.qf.dao.imple;

import java.util.List;

import com.qf.dao.SiteDao;
import com.qf.utils.DbHelp;

public class Siteimple implements SiteDao {
             
	@Override
	public List<SiteDao> queryAll() {
	String sql="select province from tb_site";
		return DbHelp.queryAll(sql,SiteDao.class);
	}

}
