package com.service;

import java.util.List;

import com.domain.Dept;

public interface DeptService {

	//查询所有部门
	List<Dept> selectAllDept(String name,String pageIndex);
	
	//添加部门
	boolean saveDept(String name,String remark);
	
	//修改部门信息
	boolean updateDept(int id,String name,String remark);
	
	//删除部门
	boolean deleteDept(String ids);
	
	//根据id查询部门
	Dept selectSingleDept(int id);
}
