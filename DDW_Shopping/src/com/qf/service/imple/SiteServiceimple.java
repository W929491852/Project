package com.qf.service.imple;
import java.util.List;
import com.qf.dao.SiteDao;
import com.qf.dao.imple.Siteimple;
import com.qf.domain.Site;


public class SiteServiceimple implements com.qf.service.SiteService{
private SiteDao dao=new Siteimple();
	@Override
	public List<SiteDao> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

}
