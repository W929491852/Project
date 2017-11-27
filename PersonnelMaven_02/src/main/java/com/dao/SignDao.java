package com.dao;

import java.util.List;

import com.domain.Sign;

public interface SignDao {

	//打卡
	boolean addSign(Sign sign);
	
	//查询某人今天是否打卡
	Sign selectSingleSign(String hql);
	
	//查询所有人的打卡情况
	List<Sign> selectAllSign(String hql);
	
	//查询从某天开始所有人的签到成功
}
