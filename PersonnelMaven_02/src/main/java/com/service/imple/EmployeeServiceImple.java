package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.domain.Employee;
import com.service.EmployeeService;
import com.utils.StringCheckEmpty;

@Service
@Transactional
public class EmployeeServiceImple implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(String ids) {
		// TODO Auto-generated method stub
		if(StringCheckEmpty.checked(ids)) {
			String[] id = ids.split(",");
			for (String str : id) {
				employeeDao.deleteEmployee(new Employee(Integer.parseInt(str)));
			}
			return true;
		}
		return false;
	}

	@Override
	public List<Employee> selectAllEmployee(String job_id,String name,String cardId,String sex,String phone,String dept_id,String pageIndex) {
		// TODO Auto-generated method stub
		String sql="select * from tb_employee where 1=1";
		if(StringCheckEmpty.checked(job_id)&&(!"0".equals(job_id))) {
			sql+=" and jid="+job_id;
		}
		if(StringCheckEmpty.checked(name)) {
			sql+=" and name like '%"+name+"%'";
		}
		if(StringCheckEmpty.checked(cardId)) {
			sql+=" adn cardId like '%"+cardId+"%'";
		}
		if("1".equals(sex)) {
			sql+=" and sex = 1";
		}else if("2".equals(sex)) {
			sql+=" and sex= 2";
		}
		if(StringCheckEmpty.checked(phone)) {
			sql+=" and phone like '%"+phone+"%'";
		}
		if(StringCheckEmpty.checked(dept_id)&&(!"0".equals(dept_id))) {
			sql+=" and did="+dept_id;
		}
		if(StringCheckEmpty.checked(pageIndex)) {
			sql+=" limit "+(Integer.parseInt(pageIndex)-1)*3+",3";
		}
		return employeeDao.selectAllEmployee(sql);
	}

	@Override
	public Employee selectSingleEmployee(String id) {
		// TODO Auto-generated method stub
		return employeeDao.selectSingleEmployee(Integer.parseInt(id));
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}
}
