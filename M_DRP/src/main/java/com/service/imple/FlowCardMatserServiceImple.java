package com.service.imple;

import java.util.Date;
import java.util.List;

import org.apache.cxf.common.i18n.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Client;
import com.domain.FlowCardDetail;
import com.domain.FlowCardMaster;
import com.domain.Inventory;
import com.domain.Item;
import com.domain.Temi;
import com.mapper.FlowCardDetailMapper;
import com.mapper.FlowCardMasterMapper;
import com.mapper.InventoryMapper;
import com.service.FlowCardMatserService;

@Service
@Transactional
public class FlowCardMatserServiceImple implements FlowCardMatserService{

	@Autowired
	private FlowCardMasterMapper flowCardMasterMapper;
	@Autowired
	private FlowCardDetailMapper flowCardDetailMapper;
	@Autowired
	private InventoryMapper inventoryMapper;
	
	@Override
	public boolean insert(int clientId,int[] itemId,int[] temi,String username,int[] qty) {
		// TODO Auto-generated method stub
		FlowCardMaster master=new FlowCardMaster();
		Client client=new Client();
		client.setClientid(clientId);
		master.setClient(client);
		master.setOptType("调拨");
		master.setRecorderId(username);
		master.setOptDate(new Date());
		flowCardMasterMapper.insert(master);
		for(int i=0;i<itemId.length;i++) {
			FlowCardDetail detail=new FlowCardDetail();
			Temi temis=new Temi();
			temis.setTemiid(temi[i]);
			//设置终端客户
			detail.setTemi(temis);
			Item item=new Item();
			item.setItemno(itemId[i]);
			//设置物料
			detail.setItem(item);
			//设置流向单
			detail.setFlowCardMaster(master);
			detail.setOptQty(1);
			detail.setAdjustQty(qty[i]);
			flowCardDetailMapper.insert(detail);
			Inventory select = inventoryMapper.select(clientId,itemId[i]);
			if(select.getInitqty()<qty[i]) {
				throw new RuntimeException("库存不够了");
			}
			inventoryMapper.updateCount(qty[i],select.getId());
		}
		return true;
	}

	@Override
	public List<FlowCardMaster> select() {
		// TODO Auto-generated method stub
		return flowCardMasterMapper.select();
	}

}
