package com.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Item;
import com.service.ItemService;

@Service
public class ItemServer implements IItemServer{

	@Autowired
	private ItemService itemService;
	@Override
	public List<Item> getAllItem() {
		// TODO Auto-generated method stub
		return itemService.selectAll();
	}

}
