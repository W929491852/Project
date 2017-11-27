package com.service;

import java.util.List;

import com.domain.Accounts;

public interface AccountsService {

	
	boolean delete(String ids);

	boolean insert(Accounts record);

	Accounts select(Integer id);

	List<Accounts> selectAll();

	boolean update(String periodsts, int id);

}
