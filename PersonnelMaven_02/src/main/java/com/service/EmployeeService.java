package com.service;

import java.util.List;

import com.domain.Employee;

public interface EmployeeService {
	
	// 新增员工
	boolean saveEmployee(Employee employee);

	// 删除员工
	boolean deleteEmployee(String ids);

	// 查询所有员工
	List<Employee> selectAllEmployee(String job_id,String name,String cardId,String sex,String phone,String dept_id,String pageIndex);

	// 根据id查询单个员工
	Employee selectSingleEmployee(String id);

	// 修改
	boolean updateEmployee(Employee employee);
}
