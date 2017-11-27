package com.service;

import java.util.List;

import com.domain.FlowCardMaster;

public interface FlowCardMatserService {

	boolean insert(int clientId,int[]itemId,int[] temi,String username,int[] qty); 
	
	List<FlowCardMaster> select();
}
