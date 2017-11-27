package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Inventory;
import com.mapper.InventoryMapper;
import com.service.InventoryService;

@Service
@Transactional
public class InventoryServiceImple implements InventoryService{

	@Autowired
	private InventoryMapper inventoryMapper;
	@Override
	public boolean insert(Inventory record) {
		// TODO Auto-generated method stub
		return inventoryMapper.insert(record)>0?true:false;
	}
	@Override
	public List<Inventory> selectInventory() {
		// TODO Auto-generated method stub
		return inventoryMapper.selectInventory();
	}
	@Override
	public boolean updade(int[] inqty, int[] id,int clientid) {
		// TODO Auto-generated method stub
		for(int i=0;i<inqty.length;i++) {
			inventoryMapper.update(inqty[i], id[i],clientid);
		}
		return true;
	}
	@Override
	public boolean update(int initqty, int id) {
		// TODO Auto-generated method stub
		return inventoryMapper.updateCount(initqty, id)>0?true:false;
	}
	@Override
	public Inventory select(int clientId, int itemno) {
		// TODO Auto-generated method stub
		return inventoryMapper.select(clientId, itemno);
	}

}
