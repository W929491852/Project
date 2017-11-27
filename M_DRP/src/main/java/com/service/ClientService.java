package com.service;

import java.util.List;

import com.domain.Client;
import com.domain.Data;

public interface ClientService {

	boolean updateClient(Client client);
	
	boolean delete(Integer clientid);
	
	boolean insert(Client record);
	
	Client select(Integer clientid);
	
	List<Client> selectAllClient();
	
	List<Data> selectData();
}
