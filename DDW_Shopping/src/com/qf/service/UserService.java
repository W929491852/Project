package com.qf.service;

import java.util.List;


import com.qf.domain.User;

//业务逻辑层：业务逻辑验证或处理
public interface UserService {

	// 新增
	boolean add(User user);

	// 查询单个用户
	User selectByName(String username);

	// 查询所有flag为1的用户
	List<User> selectAll();
	
	//查询邮箱和激活码
      User selectByemailcode(String email,String code);
      
      //修改role为0
      boolean updatarole(String email);
      
      //修改flag
      boolean updataflag(String email);
      
      //查询所有用户的信息
      List<User> getuserall();
      
	// 修改激活状态
	boolean updateCode(String email, String code);
}
