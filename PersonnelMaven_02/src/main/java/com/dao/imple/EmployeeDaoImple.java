package com.dao.imple;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.EmployeeDao;
import com.domain.Employee;
import com.utils.HibernateUtils;

@Repository
public class EmployeeDaoImple implements EmployeeDao{

	@Autowired
	private MyHibernateDao myHibernateDao;
	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return (int)myHibernateDao.getHibernateTemplate().save(employee)>0?true:false;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().delete(employee);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> selectAllEmployee(String sql) {
		// TODO Auto-generated method stub
		return (List<Employee>) myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return HibernateUtils.selectAll(session, sql, Employee.class);
			}});
	}

	@Override
	public Employee selectSingleEmployee(int id) {
		// TODO Auto-generated method stub
		return (Employee) myHibernateDao.getHibernateTemplate().find("from Employee where id=?", id).get(0);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().update(employee);
		return true;
	}

}
