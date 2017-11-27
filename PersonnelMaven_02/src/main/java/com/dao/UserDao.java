package com.dao;

import java.util.List;

import com.domain.User;

public interface UserDao {
	// 验证用户名和密码是否正确
	User selectUser(String loginName, String passWord);
	//获取所有的用户
	List<User> selectAllUser(String sql);
	//查询指定id用户
	User selectSingleUser(int id);
	//修改用户
	boolean updateUser(User user);
	//添加用户
	boolean saveUser(User user);
	//删除用户
	boolean deleteUser(User user);
}
