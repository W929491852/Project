package com.dao;

import java.util.List;

import com.domain.Job;

public interface JobDao {

	// 查询所有职位
	List<Job> selectAllJob(String sql);

	// 添加职位
	boolean saveJob(Job job);

	// 修改职位
	boolean updateJob(Job job);

	// 删除职位
	boolean deleteJob(Job job);

	// 根据id查询职位信息
	Job selectSngleJob(int id);
}
