package com.service;

import java.util.List;

import com.domain.User;

public interface UserService {

	int deleteUser(String ids);
	
	int insertUser(User user);
	
	int updateUser(User user);
	
	User selectUser(String username,String password);
	
	List<User> selectAllUser(int page,int count);
	
	User selectUserById(Integer id);
}
