package com.service;

import java.util.List;

import com.domain.Inventory;

public interface InventoryService {

	 boolean insert(Inventory record);
	 
	 List<Inventory> selectInventory();
	 
	 boolean updade(int[] inqty,int[] id,int clientid);
	 
	 boolean update(int initqty,int id);
	 
	 Inventory select(int clientId,int itemno);
}
