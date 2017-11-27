package com.qf.dao;

import java.util.List;

import com.qf.domain.User;

//操作数据库的接口,规范方法
public interface UserDao {

	//新增
	boolean add(User user);
	//查询单个用户
	User selectByName(String username);
	//查询用户激活码和邮箱
	User selectByemailcode(String email,String code);
	
	//修改flag
	boolean updataflag(String email);
	//修改role(管理员)
	boolean updatarole(String email);
	
	//查询所有flag为1的用户
	List<User> selectAll();
	//修改激活状态
	boolean updateCode(String email,String code);
	
	//查询所有用户的信息
	List<User> getuserall();
}
