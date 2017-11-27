package com.service;

import java.util.List;

import com.domain.User;

public interface UserService {

	// 查询用户
	User selectUser(String loginName, String passWord);

	// 获取所有的用户
	List<User> selectAllUser(String username, String status,String pageIndex);
	
	//查询用户
	User selectSingleUser(String id);
	
	//修改用户
	boolean updateUser(User user);
	
	//保存用户
	boolean saveUser(User user);
	
	//删除用户
	boolean deleteUser(String ids);
}
