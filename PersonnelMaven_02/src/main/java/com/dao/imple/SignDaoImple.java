package com.dao.imple;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.SignDao;
import com.domain.Sign;
import com.utils.HibernateUtils;

@Repository
public class SignDaoImple implements SignDao{

	@Autowired
	private MyHibernateDao myHibernateDao;
	@Override
	public boolean addSign(Sign sign) {
		// TODO Auto-generated method stub
		return (int)myHibernateDao.getHibernateTemplate().save(sign)>0?true:false;
	}

	@Override
	public Sign selectSingleSign(String hql) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Sign> find=(List<Sign>) myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return HibernateUtils.selectAll(session, hql, Sign.class);
			}
		});
		if(find!=null&&find.size()!=0) {
			return find.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sign> selectAllSign(String sql) {
		// TODO Auto-generated method stub
		return (List<Sign>) myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return HibernateUtils.selectAll(session, sql, Sign.class);
			}
		});
	}

}
