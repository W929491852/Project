package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Item;
import com.mapper.ItemMapper;
import com.service.ItemService;

@Service
@Transactional
public class ItemServiceImple implements ItemService{

	@Autowired ItemMapper itemMapper;
	@Override
	public boolean insert(Item record) {
		// TODO Auto-generated method stub
		return itemMapper.insert(record)>0?true:false;
	}

	@Override
	public Item select(Integer itemno) {
		// TODO Auto-generated method stub
		return itemMapper.select(itemno);
	}

	@Override
	public boolean update(Item record) {
		// TODO Auto-generated method stub
		return itemMapper.update(record)>0?true:false;
	}

	@Override
	public boolean delete(String ids) {
		// TODO Auto-generated method stub
		String[] strs=ids.split(",");
		for(int i=0;i<strs.length;i++) {
			if(!strs[i].equals("")) {
				itemMapper.delete(Integer.parseInt(strs[i]));
			}
		}
		return true;
	}

	@Override
	public List<Item> selectAll() {
		// TODO Auto-generated method stub
		return itemMapper.selectAll();
	}

	@Override
	public boolean updateImage(String path, int itemno) {
		// TODO Auto-generated method stub
		return itemMapper.updateImage(path, itemno)>0?true:false;
	}

	@Override
	public List<Item> selectAllByName(String name) {
		// TODO Auto-generated method stub
		return itemMapper.selectAllByName("%"+name+"%");
	}

	@Override
	public List<Item> selectAllByClientId(int clientId) {
		// TODO Auto-generated method stub
		return itemMapper.selectAllByClientId(clientId);
	}

}
