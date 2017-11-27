package com.service;

import java.util.List;

import com.domain.Sign;

public interface SignService {

	//打卡
	boolean addSign(String id);
	
	//查询用户是否已经打卡
	Sign selectSign(String id);
	
	//查询所有用户的打卡情况
	List<Sign> selectAllSign(String startDate,String endDate,String pageIndex);
}
