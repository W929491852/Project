package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Client;
import com.domain.Data;
import com.mapper.ClientMapper;
import com.service.ClientService;

@Service
@Transactional
class ClientServiceImple implements ClientService{

	@Autowired
	private ClientMapper clientMapper;
	
	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		return clientMapper.update(client)>0?true:false;
	}

	@Override
	public boolean delete(Integer clientid) {
		// TODO Auto-generated method stub
		return clientMapper.delete(clientid)>0?true:false;
	}

	@Override
	public boolean insert(Client record) {
		// TODO Auto-generated method stub
		return clientMapper.insert(record)>0?true:false;
	}

	@Override
	public Client select(Integer clientid) {
		// TODO Auto-generated method stub
		System.out.println("分销商对象:"+ clientMapper.select(clientid));
		return clientMapper.select(clientid);
	}

	@Override
	public List<Client> selectAllClient() {
		// TODO Auto-generated method stub
		return clientMapper.selectAllClient();
	}

	@Override
	public List<Data> selectData() {
		// TODO Auto-generated method stub
		return clientMapper.selectData();
	}


}
