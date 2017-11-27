package com.dao.imple;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.NoticeDao;
import com.domain.Job;
import com.domain.Notice;
import com.utils.HibernateUtils;

@Repository
public class NoticeDaoImple implements NoticeDao{

	@Autowired
	private MyHibernateDao myHibernateDao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> selectAllNotice(String sql) {
		// TODO Auto-generated method stub
		return (List<Notice>) myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return HibernateUtils.selectAll(session, sql, Notice.class);
			}
		});
	}

	@Override
	public boolean saveNotice(Notice notice) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().save(notice);
		return true;
	}

	@Override
	public boolean updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().update(notice);
		return true;
	}

	@Override
	public boolean deleteNotice(Notice notice) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().delete(notice);
		return true;
	}

	@Override
	public Notice selectSngleNotice(int id) {
		// TODO Auto-generated method stub
		return (Notice) myHibernateDao.getHibernateTemplate().find("from Notice where id=?", id).get(0);
	}

}
