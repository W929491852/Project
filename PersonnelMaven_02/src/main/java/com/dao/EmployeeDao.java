package com.dao;

import java.util.List;

import com.domain.Employee;

public interface EmployeeDao {

	//新增员工
	boolean saveEmployee(Employee employee);
	
	//删除员工
	boolean deleteEmployee(Employee employee);
	
	//查询所有员工
	List<Employee> selectAllEmployee(String sql);
	
	//根据id查询单个员工
	Employee selectSingleEmployee(int id);
	
	//修改
	boolean updateEmployee(Employee employee);
}
