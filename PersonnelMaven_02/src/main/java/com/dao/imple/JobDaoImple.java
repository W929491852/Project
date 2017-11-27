package com.dao.imple;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.JobDao;
import com.domain.Job;
import com.utils.HibernateUtils;

@Repository
public class JobDaoImple implements JobDao{

	@Autowired
	private MyHibernateDao myHibernateDao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Job> selectAllJob(String sql) {
		return (List<Job>) myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return HibernateUtils.selectAll(session, sql, Job.class);
			}
		});
	}

	@Override
	public boolean saveJob(Job job) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().save(job);
		return true;
	}

	@Override
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().update(job);
		return true;
	}

	@Override
	public boolean deleteJob(Job job) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().delete(job);
		return true;
	}

	@Override
	public Job selectSngleJob(int id) {
		// TODO Auto-generated method stub
		return (Job) myHibernateDao.getHibernateTemplate().find("from Job where id=?", id).get(0);
	}

}
