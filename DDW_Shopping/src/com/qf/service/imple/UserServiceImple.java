package com.qf.service.imple;

import java.util.*;


import com.qf.dao.UserDao;
import com.qf.dao.imple.UserDaoImple;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.utils.MD5Utils;

//实现类，拥有dao层对象
public class UserServiceImple implements UserService{

	private UserDao dao=new UserDaoImple();
	
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return dao.add(user);
	}

	@Override
	public User selectByName(String username) {
		// TODO Auto-generated method stub
		return dao.selectByName(username);
	}
	
	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public boolean updateCode(String email, String code) {
		// TODO Auto-generated method stub
		return dao.updateCode(email, code);
	}

	@Override
	public User selectByemailcode(String email,String code){
		// TODO Auto-generated method stub
		return dao.selectByemailcode(email, code);
	}

	@Override
	public boolean updataflag(String email) {
		// TODO Auto-generated method stub
		return dao.updataflag(email);
	}

	@Override
	public boolean updatarole(String email) {
		// TODO Auto-generated method stub
		return dao.updatarole(email);
	}

	@Override
	public List<User> getuserall() {
		// TODO Auto-generated method stub
		return dao.getuserall();
	}

  

}
