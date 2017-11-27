package com.qf.dao.imple;

import java.util.List;

import java.util.Set;

import com.qf.dao.UserDao;
import com.qf.domain.User;
import com.qf.utils.DbHelp;



//进行SQl的操作
public class UserDaoImple implements UserDao{

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return DbHelp.update("insert into tb_user(username,password,email,gender,flag,role,code) values(?,?,?,?,?,?,?)", 
				user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getFlag(),user.getRole(),user.getCode());
	}

	@Override
	public User selectByName(String username) {
		// TODO Auto-generated method stub
		return DbHelp.querySingle("select * from tb_user where username=? and flag=1", User.class, username);
	}

	@Override
	public User selectByemailcode(String email,String code) {
		// TODO Auto-generated method stub
		return DbHelp.querySingle("select * from tb_user where email=? and code=?", User.class, email,code);
	}
	
	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return DbHelp.queryAll("select * from tb_user where flag=1", User.class);
	}
	
	public boolean updataflag(String email){
		return DbHelp.update("update tb_user set flag=1 where email=?", email);
		      
	}

	@Override
	public boolean updateCode(String email, String code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatarole(String email) {
		// TODO Auto-generated method stub
		return DbHelp.update("update tb_user set role='0' where email=?", email);
	}

	@Override
	public List<User> getuserall() {
		
		return DbHelp.queryAll("select * from tb_user", User.class);
	}
	
	

}
