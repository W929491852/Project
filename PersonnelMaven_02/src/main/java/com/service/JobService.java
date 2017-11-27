package com.service;

import java.util.List;

import com.domain.Job;

public interface JobService {
	// 查询所有部门
	List<Job> selectAllJob(String name,String pageIndex);

	// 添加部门
	boolean saveJob(String name, String remark);

	// 修改部门信息
	boolean updateJob(int id, String name, String remark);

	// 删除部门
	boolean deleteJob(String ids);

	// 根据id查询部门
	Job selectSingleJob(int id);
}
