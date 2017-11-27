package com.dao.imple;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.DeptDao;
import com.domain.Dept;
import com.utils.HibernateUtils;
@Repository
public class DeptDaoImple implements DeptDao{

	@Autowired
	private MyHibernateDao myHibernateDao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> selectAllDept(String sql) {
		// TODO Auto-generated method stub
		return (List<Dept>) myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return HibernateUtils.selectAll(session, sql, Dept.class);
			}
		});
	}

	@Override
	public boolean saveDept(Dept dept) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().save(dept);
		return true;
	}

	@Override
	public boolean updateDept(Dept dept) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().update(dept);
		return true;
	}

	@Override
	public boolean deleteDept(Dept dept) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().delete(dept);
		return true;
	}

	@Override
	public Dept selectSngleDept(int id) {
		// TODO Auto-generated method stub
		return (Dept) myHibernateDao.getHibernateTemplate().find("from Dept where id=?", id).get(0);
	}

}
