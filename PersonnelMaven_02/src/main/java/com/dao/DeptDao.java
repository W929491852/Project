package com.dao;

import java.util.List;

import com.domain.Dept;

public interface DeptDao {

	//查询所有部门
	List<Dept> selectAllDept(String sql);
	
	//添加部门
	boolean saveDept(Dept dept);
	
	//修改部门
	boolean updateDept(Dept dept);
	
	//删除部门
	boolean deleteDept(Dept dept);
	
	//根据id查询部门信息
	Dept selectSngleDept(int id);
}
