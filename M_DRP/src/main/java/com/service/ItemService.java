package com.service;

import java.util.List;

import com.domain.Item;

public interface ItemService {
	
	boolean insert(Item record);

	Item select(Integer itemno);

	boolean update(Item record);

	boolean delete(String ids);

	List<Item> selectAll();
	
	List<Item> selectAllByClientId(int clientId);
	
	boolean updateImage(String path,int itemno);
	
	List<Item> selectAllByName(String name);
}
