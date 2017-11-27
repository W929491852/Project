package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import com.utils.StringCheckEmpty;

@Service
@Transactional
public class UserServiceImple implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public User selectUser(String loginName, String passWord) {
		// TODO Auto-generated method stub
		if(!StringCheckEmpty.checked(loginName,passWord)) {
			return null;
		}
		return userDao.selectUser(loginName, passWord);
	}
	@Override
	public List<User> selectAllUser(String username, String status,String pageIndex) {
		// TODO Auto-generated method stub
		String sql="select * from tb_user where 1=1";
		if(!(username==null||"".equals(username))) {
			sql+=" and username like '%"+username+"%'";
		}
		if(!(status==null||"".equals(status))) {
			sql+=" and status="+status;
		}
		if(StringCheckEmpty.checked(pageIndex)) {
			sql+=" limit "+(Integer.parseInt(pageIndex)-1)*3+",3";
		}
		System.out.println("查看所有用户的hql语句:"+sql);
		return userDao.selectAllUser(sql);
	}
	@Override
	public User selectSingleUser(String id) {
		// TODO Auto-generated method stub
		return userDao.selectSingleUser(Integer.parseInt(id));
	}
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.saveUser(user);
	}
	@Override
	public boolean deleteUser(String ids) {
		// TODO Auto-generated method stub
		String[] id=ids.split(",");
		for(int i=0;i<id.length;i++) {
			User user=new User();
			user.setId(Integer.parseInt(id[i]));
			userDao.deleteUser(user);
		}
		return true;
	}
	

}
