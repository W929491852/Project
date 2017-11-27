package com.service.imple;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.User;
import com.mapper.UserMapper;
import com.service.UserService;

@Service
@Transactional
public class UserServiceImple implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public int deleteUser(String ids) {
		// TODO Auto-generated method stub
		String[] strs=ids.split(",");
		System.out.println(Arrays.toString(strs));
		for(int i=0;i<strs.length;i++) {
			if(strs[i]!=null) {
				userMapper.deleteByPrimaryKey(Integer.parseInt(strs[i]));
			}
		}
		return 1;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User selectUser(String username, String password) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(username, password);
	}

	@Override
	public List<User> selectAllUser(int page,int count) {
		// TODO Auto-generated method stub
		return userMapper.selectAllUser((page-1)*count,count);
	}

	@Override
	public User selectUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(id);
	}

}
