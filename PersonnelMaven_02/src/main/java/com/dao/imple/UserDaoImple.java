package com.dao.imple;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.domain.User;
import com.sun.org.apache.regexp.internal.recompile;
import com.utils.HibernateUtils;

@Repository
public class UserDaoImple implements UserDao{

	@Autowired
	private MyHibernateDao myHibernateDao;
	@Override
	public User selectUser(String loginName, String passWord) {
		// TODO Auto-generated method stub
		List<User> list=(List<User>) myHibernateDao.getHibernateTemplate().find("from User where loginname=? and password=?", loginName,passWord);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUser(String sql) {
		// TODO Auto-generated method stub
		return (List<User>) myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return  HibernateUtils.selectAll(session, sql, User.class);
			}
		});
	}

	@Override
	public User selectSingleUser(int id) {
		// TODO Auto-generated method stub
		return (User) myHibernateDao.getHibernateTemplate().find("from User where id=?",id).get(0);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().update(user);
		return true;
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return (int)myHibernateDao.getHibernateTemplate().save(user)>0?true:false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().delete(user);
		return true;
	}

	

	
}
